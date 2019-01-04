package com.testtask.apptesttask.ui.global

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.testtask.apptesttask.entity.charactrers.Character
import com.testtask.apptesttask.presentation.characters.CharactersView

class CharactersAdapter constructor(
    val context: Context,
    val characters: List<Character>,
    private val listener: CharactersView
) : RecyclerView.Adapter<CharactersHolder>() {

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): CharactersHolder {
        val itemView = LayoutInflater.from(context).inflate(null, view, false)
        val holder = CharactersHolder(itemView)

        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val character = characters[position]
                listener.favorCharacter(character)
            }
        }

        return holder
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharactersHolder, positon: Int) {
        val character = characters[positon]
        holder.bind(character.apiCharacter)
        holder.updateStar(character.favorite)
    }
}