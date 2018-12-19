package com.testtask.apptesttask.model.interactor.characters

import com.testtask.apptesttask.model.repository.MarvelRepository
import javax.inject.Inject

class CharactersInteractor @Inject constructor(var marvelRepository: MarvelRepository) :
    Interactor {

    override fun getCharacters(ts: String, apikey: String, hash: String) =
            marvelRepository.getHeroesList(ts, apikey, hash)

    override fun setFavoritesCharacters(id: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}