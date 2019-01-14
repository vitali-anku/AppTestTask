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

    fun getCharacters(): Single<List<Character>> =
            Single.zip(
                marvelService
                        .getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
                        .map { it.data.results },
                Single.just(prefs.favoritesCharacters),
                BiFunction<List<ApiCharacter>, Map<Int, Character>?,
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

            Single.just(character)
                    .map {
                        val favoriteCharacter = it.copy(favorite = !it.favorite)
                        val favoriteCharacters = prefs.favoritesCharacters

                        if (favoriteCharacters.contains(it.id)) {
                            favoriteCharacters.remove(it.id)
                            prefs.favoritesCharacters = favoriteCharacters
                        } else {
                            favoriteCharacters[it.id] = favoriteCharacter
                            prefs.favoritesCharacters = favoriteCharacters
                        }
                        favoriteCharacter
                    }
                    .subscribeOn(schedulers.newThread())
                    .observeOn(schedulers.ui())
}

