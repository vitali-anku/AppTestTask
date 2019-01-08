package com.testtask.apptesttask.model.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.testtask.apptesttask.entity.charactrers.Character
import javax.inject.Inject

class Prefs @Inject constructor(
    context: Context,
    private val gson: Gson
) {

    private val PREF_TAG = "characters"
    private val FAVORITE_CHARACTERS = "favorite_characters"

    private val sharedPreferences =
            context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE)

    var favoritesCharacters: MutableMap<Int, Character>?
        get() = convertArrayToMutableList(sharedPreferences.getString(FAVORITE_CHARACTERS, null))
        set(value) {
            sharedPreferences.edit().putString(FAVORITE_CHARACTERS, gson.toJson(value))
                    .apply()
        }

    private fun convertArrayToMutableList(valueString: String?): MutableMap<Int, Character> {
        val mutableList = mutableMapOf<Int, Character>()
        val typeToken = object : TypeToken<Map<Int, Character>>() {}.type
        valueString?.let {
            mutableList.putAll(gson.fromJson(it, typeToken))
        }

        return mutableList
    }
}