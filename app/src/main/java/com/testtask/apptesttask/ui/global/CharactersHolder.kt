package com.testtask.apptesttask.ui.global

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character

class CharactersHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: Character) {
        itemView.findViewById<TextView>(R.id.name_character).text = character.name
        itemView.findViewById<TextView>(R.id.description_character).text = character.description
        Glide
                .with(itemView)
                .load(character.thumbnail.path + "." + character.thumbnail.extension)
                .into(itemView.findViewById(R.id.image_character))

        if (character.favorite)
            itemView.findViewById<ImageView>(R.id.image_star).setImageResource(R.drawable.ic_star)
        else
            itemView.findViewById<ImageView>(R.id.image_star).setImageResource(R.drawable.ic_empty_star)
    }
}