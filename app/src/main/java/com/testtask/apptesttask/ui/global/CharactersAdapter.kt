package com.testtask.apptesttask.ui.global

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.testtask.apptesttask.entity.charactrers.Character

class CharactersAdapter constructor(
    val context: Context,
    private val listener: (position: Int) -> Unit
) : RecyclerView.Adapter<CharactersHolder>() {

    private var characters = mutableListOf<Character>()

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): CharactersHolder {
        val itemView = LayoutInflater.from(context).inflate(null, view, false)
        val holder = CharactersHolder(itemView)
        holder.itemView.setOnClickListener {
            listener(holder.adapterPosition)
        }

        return holder
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharactersHolder, positon: Int) {
        val character = characters[positon]
        holder.bind(character)
    }

    override fun onBindViewHolder(
        holder: CharactersHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)

        val character = characters[position]
        holder.updateStar(character.favorite!!)
    }

    fun updateCharacters(newCharacters: List<Character>) {
        val oldItems = characters.toList()

        characters.clear()
        characters.addAll(newCharacters)
        DiffUtil.calculateDiff(DiffCallback(characters, oldItems))
                .dispatchUpdatesTo(this)
    }

    private inner class DiffCallback(
        private val newItems: List<Character>,
        private val oldItems: List<Character>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldItems.size

        override fun getNewListSize() = newItems.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return oldItem == newItem
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            val oldItem = oldItems[oldItemPosition]
            val newItem = newItems[newItemPosition]

            return oldItem.favorite == newItem.favorite
        }
    }
}