package com.testtask.apptesttask.model.storage

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.testtask.apptesttask.entity.charactrers.Character
import javax.inject.Inject

class Prefs @Inject constructor(
    private val context: Context,
    private val gson: Gson
) {

    private val PREF_TAG = "characters"
    private val FAVORITE_CHARACTERS = "favorite_characters"

    var sharedPreferences =
            context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE)

    var favoritesCharacters: MutableMap<Int, Character>
        get() = convertCharacters(sharedPreferences.getString(FAVORITE_CHARACTERS, null))
        set(value) {
            sharedPreferences.edit()
                    .putString(FAVORITE_CHARACTERS, gson.toJson(value))
                    .apply()
        }

    private fun convertCharacters(json: String?): MutableMap<Int, Character> {
        val characters = mutableMapOf<Int, Character>()
        json?.let {
            val typeToken = object : TypeToken<Map<Int, Character>>() {}.type
            characters.putAll(gson.fromJson(it, typeToken))
        }
        return characters
    }
}