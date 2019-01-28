package com.testtask.apptesttask.ui.global

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.glide.GlideApp

class FavoritesCharactersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: Character) {
        itemView.findViewById<TextView>(R.id.name_favorite_character).text = character.name
        itemView.findViewById<TextView>(R.id.description_favorite_character).text =
                character.description
        GlideApp
                .with(itemView)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .override(105)
                .into(itemView.findViewById(R.id.image_favorite_character))
    }
}