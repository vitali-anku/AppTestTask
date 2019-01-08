package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.entity.charactrers.ApiCharacter
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.data.server.MarvelService
import com.testtask.apptesttask.model.storage.Prefs
import com.testtask.apptesttask.model.system.SchedulersProvider
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelService: MarvelService,
    private val appConfig: AppConfig,
    private val schedulers: SchedulersProvider,
    private val prefs: Prefs
) {

    private fun getApiCharacters() = marvelService
            .getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
            .flatMap { characterDataWrapper ->
                Single.just(characterDataWrapper.data.results)
            }

    private fun getPrefs(): Single<Map<Int, Character>> =
            Single.just(prefs.favoritesCharacters)

    fun getCharacters(): Single<List<Character>> =
            Single.zip(
                getApiCharacters(),
                getPrefs(),
                BiFunction<List<ApiCharacter>, Map<Int, Character>?, List<Character>> { apiCharacters, favorites ->
                    apiCharacters.map {
                        val id = it.id
                        Character(
                            id,
                            it.name,
                            it.description,
                            it.modified,
                            it.resourceURI,
                            it.urls,
                            it.thumbnail,
                            it.comics,
                            it.stories,
                            it.events,
                            it.series,
                            if (favorites.containsKey(id)) {
                                favorites[id]?.favorite
                            } else
                                false
                        )
                    }
                }
            )
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())

    fun favorCharacter(id: Int, character: Character) {
        if (prefs.favoritesCharacters!!.containsKey(id)) {
            prefs.favoritesCharacters!!.remove(id)
        } else {
            prefs.favoritesCharacters!![id] = character
        }
    }
}
