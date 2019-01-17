package com.testtask.apptesttask.model.repository

import com.testtask.apptesttask.entity.AppConfig
import com.testtask.apptesttask.entity.charactrers.ApiCharacter
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.data.server.MarvelService
import com.testtask.apptesttask.model.storage.Prefs
import com.testtask.apptesttask.model.system.SchedulersProvider
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val marvelService: MarvelService,
    private val appConfig: AppConfig,
    private val schedulers: SchedulersProvider,
    private val prefs: Prefs
) {

    fun getCharacters(): Single<List<Character>> =
            Single
                    .zip(
                        marvelService
                                .getCharacters(
                                    appConfig.ts,
                                    appConfig.publicKey,
                                    appConfig.hash
                                )
                                .map { it.data.results },
                        Single.just(prefs.favoritesCharacters),
                        BiFunction<List<ApiCharacter>, Map<Int, Character>,
                                List<Character>> { apiCharacters, favorites ->
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
                                    favorites[id]?.favorite ?: false
                                )
                            }
                        }
                    )
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())

    fun favorCharacter(character: Character): Single<Character> =
            Single
                    .fromCallable {
                        val newCharacter = character.copy(favorite = !character.favorite)
                        val characters = prefs.favoritesCharacters

                        if (characters.contains(character.id)) {
                            characters.remove(character.id)
                        } else {
                            characters[character.id] = newCharacter
                        }
                        prefs.favoritesCharacters = characters
                        newCharacter
                    }
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())

    fun getFavoriteCharacters(): Observable<MutableList<Character>> =
            Observable
                    .just(prefs.favoritesCharacters)
                    .map {
                        val characters = mutableListOf<Character>()
                        for (id in it.keys) {
                            characters.add(it[id]!!)
                        }
                        characters
                    }
                    .subscribeOn(schedulers.io())
                    .observeOn(schedulers.ui())
}