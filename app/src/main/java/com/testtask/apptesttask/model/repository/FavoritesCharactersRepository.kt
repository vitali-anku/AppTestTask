package com.testtask.apptesttask.model.repository

import android.content.SharedPreferences
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.storage.Prefs
import com.testtask.apptesttask.model.system.SchedulersProvider
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class FavoritesCharactersRepository @Inject constructor(
    private val prefs: Prefs,
    private val schedulers: SchedulersProvider
) {

    val subject = BehaviorSubject.create<List<Character>>()

    val listener = SharedPreferences.OnSharedPreferenceChangeListener { preference, key ->
        subject.onNext(convertMapToList())
    }

    init {
        prefs.sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        subject.onNext(convertMapToList())
    }

    fun getFavoritesCharacters(): Observable<List<Character>> =
            subject
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())

    fun convertMapToList(): List<Character> {
        val characters = mutableListOf<Character>()
        for (id in prefs.favoritesCharacters.keys) {
            characters.add(prefs.favoritesCharacters[id]!!)
        }
        return characters
    }
}