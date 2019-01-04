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
    private val sharedPreference: Prefs
) {

    private fun getApiCharacters(): Single<List<ApiCharacter>> = marvelService
            .getCharacters(appConfig.ts, appConfig.publicKey, appConfig.hash)
            .flatMap { characterDataWrapper -> Single.just(characterDataWrapper.data.results) }

    fun getCharacters(): Single<List<Character>> = Single
            .zip(
                getApiCharacters(),
                Single.just(sharedPreference.favoritesCharacters),
                BiFunction<List<ApiCharacter>, List<Boolean>?, List<Character>> { apiCharacters, favorites ->
                    apiCharacters.map { apiCharacter ->
                        val position = apiCharacters.indexOf(apiCharacter)
                        if (favorites.isNotEmpty()) {
                            Character(apiCharacter, favorites[position])
                        } else
                            Character(apiCharacter, false)
                    }
                }
            )
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

    fun favoriteCharacter(character: Character, favorite: Boolean) {
        character.favorite = !favorite
    }
}
