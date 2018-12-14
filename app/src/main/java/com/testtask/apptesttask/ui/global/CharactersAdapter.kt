package com.testtask.apptesttask.ui.global

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.testtask.apptesttask.R
import com.testtask.apptesttask.model.di.module.GlideApp
import com.testtask.apptesttask.presentation.base.CharacterViewHolder
import com.testtask.apptesttask.presentation.characters.CharactersPresenter
import kotlinx.android.synthetic.main.card_characters.view.*
import javax.inject.Inject

class CharactersAdapter @Inject constructor(val presenter: CharactersPresenter) :
    RecyclerView.Adapter<CharactersAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CharacterHolder =
            CharacterHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.card_characters, parent, false)
            )

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        presenter.onBindCharacterRowViewAtPosition(position, holder)
        holder.itemView.setOnClickListener {
            presenter.clickedLikeCharacter(position, holder)
        }
    }

    override fun getItemCount(): Int = presenter.getCount()

    class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView), CharacterViewHolder {

        override fun setStar(resid: Int) {
            Log.e("ImagePath", resid.toString())
            itemView.image_star.setBackgroundResource(resid)
        }

        override fun setData(avatar: String, name: String, description: String) {
            Log.e("tag", description)
            GlideApp.with(itemView.context)
                    .load(avatar)
                    .into(itemView.image_character)
            itemView.name_character.text = name
            itemView.description_character.text = description
        }
    }
}