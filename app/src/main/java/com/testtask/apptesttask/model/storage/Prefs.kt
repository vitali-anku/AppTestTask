package com.testtask.apptesttask.model.storage

import android.content.Context
import com.google.gson.Gson
import javax.inject.Inject

class Prefs @Inject constructor(context: Context, val gson: Gson) {

    private val PREF_TAG = "characters"
    private val FAVORITE_CHARACTER = "favorite_characters"

    private val sharedPreferences =
            context.getSharedPreferences(PREF_TAG, Context.MODE_PRIVATE)

    var favoritesCharacters: MutableList<Boolean>?
        get() = convertArrayToMutableList(sharedPreferences.getString(FAVORITE_CHARACTER, null))
        set(value) {
            sharedPreferences.edit().putString(FAVORITE_CHARACTER, gson.toJson(value))
                    .apply()
        }

    private fun convertArrayToMutableList(valueString: String?): MutableList<Boolean> {
        val mutableList = mutableListOf<Boolean>()
        valueString?.let {
            val arrayValue = gson.fromJson(it, Array<Boolean>::class.java)
            for (item: Boolean in arrayValue) {
                mutableList.add(item)
            }
        }
        return mutableList
    }
}