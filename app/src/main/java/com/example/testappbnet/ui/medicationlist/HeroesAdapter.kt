package com.example.testappbnet.ui.medicationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testappbnet.R
import com.example.testappbnet.domain.models.Hero
import com.example.testappbnet.ui.medicationlist.HeroesAdapter.HeroesViewHolder
import com.squareup.picasso.Picasso

class HeroesAdapter(
    private val listenerHero: (hero: Hero) -> Unit,
) : ListAdapter<Hero, HeroesViewHolder>(HeroesComparator()) {

    class HeroesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView by lazy { itemView.findViewById(R.id.ivPoster) }
        private val name: TextView by lazy { itemView.findViewById(R.id.tvFullName) }

        fun bind(item: Hero) {
            name.text = item.name
            Picasso.get().load(item.image).into(image)
        }
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listenerHero(getItem(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hero_item, parent, false)
        return HeroesViewHolder(view)
    }

    class HeroesComparator : DiffUtil.ItemCallback<Hero>() {

        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}