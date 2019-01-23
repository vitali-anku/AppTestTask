package com.testtask.apptesttask.ui.global

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.testtask.apptesttask.R
import com.testtask.apptesttask.entity.charactrers.Character

class FavoritesCharactersAdapter constructor(
    val context: Context
) : RecyclerView.Adapter<FavoritesCharactersHolder>() {

    private var items = mutableListOf<Character>()

    override fun onCreateViewHolder(view: ViewGroup, viewType: Int): FavoritesCharactersHolder =
            FavoritesCharactersHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_favorite_character,
                    view,
                    false
                )
            )

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FavoritesCharactersHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setCharacters(characters: List<Character>) {
        val oldItems = items.toList()

        items.clear()
        items.addAll(characters)
        DiffUtil.calculateDiff(DiffCallback(items, oldItems))
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