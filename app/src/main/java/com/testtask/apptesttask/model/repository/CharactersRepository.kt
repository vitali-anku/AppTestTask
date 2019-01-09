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

    private val characters = mutableListOf<Character>()

    fun getCharacters(): Single<List<Character>> =
            Single.zip(
                marvelService
                        .getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
                        .flatMap { characterDataWrapper ->
                            Single.just(characterDataWrapper.data.results)
                        },
                Single.just(prefs.favoritesCharacters),
                BiFunction<List<ApiCharacter>, Map<Int, Character>?, List<Character>> { apiCharacters, favorites ->
                    apiCharacters.map {
                        val id = it.id
                        characters.add(
                            id, Character(
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
                                favorites[id]?.favorite ?: false
                            )
                        )
                    }
                    characters
                }
            )
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())

    fun favorCharacter(position: Int): Single<MutableList<Character>>? {
        val character = characters[position].copy(favorite = !characters[position].favorite)
        val id = character.id
        characters.add(id, character)

        if (prefs.favoritesCharacters!!.containsKey(id)) {
            prefs.favoritesCharacters!!.remove(id)
        } else {
            prefs.favoritesCharacters!![id] = character
        }

        return Single.just(characters)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }
}
