package com.testtask.apptesttask.presentation.characters

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.testtask.apptesttask.BuildConfig
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.model.repository.MarvelRepository
import com.testtask.apptesttask.presentation.base.BasePresenter
import com.testtask.apptesttask.presentation.base.CharacterViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class CharactersPresenter @Inject constructor(private var marvelRepository: MarvelRepository) :
    BasePresenter<CharactersView>() {

    private var likesCharacter = mutableListOf<Character>()

    private var characterList = mutableListOf<Character>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.e("tag", "onAttach")
        loadCharacters()
    }

    private fun loadCharacters() {
        unsubscribeOnDestroy(
            marvelRepository.getHeroesList(
                BuildConfig.TS,
                BuildConfig.PUBLIC_KEY,
                BuildConfig.HASH
            )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe { showProgress() }
                    .subscribe({ characterDataWrapper ->
                        characterList.addAll(characterDataWrapper.data.results)
                        viewState.showCharacters()
                        hideProgress()
                    },
                        { error ->
                            showError(error as Throwable)
                            hideProgress()
                        })
        )
    }

    fun onBindCharacterRowViewAtPosition(position: Int, view: CharacterViewHolder) {
        val character: Character = characterList[position]
        view.setData(
            character.thumbnail.path + "." + character.thumbnail.extension,
            character.name,
            character.description
        )
        view.setStar(R.drawable.ic_dont_like_star)
    }

    fun clickedLikeCharacter(position: Int, view: CharacterViewHolder) {
        val character = characterList[position]
        if (!likesCharacter.isEmpty()) {
            if (likesCharacter.contains(character)) {
                dislikeCharacter(character, view)
            } else {
                likeCharacter(character, view)
            }
        } else
            likeCharacter(character, view)
    }

    fun likeCharacter(character: Character, view: CharacterViewHolder) {
        likesCharacter.add(character)
        view.setStar(R.drawable.ic_like_star)
    }

    fun dislikeCharacter(character: Character, view: CharacterViewHolder) {
        likesCharacter.remove(character)
        view.setStar(R.drawable.ic_dont_like_star)
    }

    fun getCount(): Int {
        return characterList.size
    }

    private fun showProgress() {
        viewState.showProgress()
    }

    private fun hideProgress() {
        viewState.hideProgress()
    }

    fun refresh() {
        loadCharacters()
    }

    private fun showError(error: Throwable) {
        viewState.showMessage(error)
    }
}
