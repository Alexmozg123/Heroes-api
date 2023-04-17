package com.example.testappbnet.screens.medicationlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testappbnet.R
import com.example.testappbnet.models.Hero
import com.example.testappbnet.screens.medicationlist.HeroesAdapter.*
import com.squareup.picasso.Picasso

class HeroesAdapter(
    private val items: List<Hero>
) : ListAdapter<Hero, MedicationViewHolder>(DrugsComparator()) {

    class MedicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView by lazy { itemView.findViewById(R.id.ivPoster) }
        private val name: TextView by lazy { itemView.findViewById(R.id.tvTitle) }
        private val status: TextView by lazy { itemView.findViewById(R.id.tvDescription) }

        fun bind(item: Hero) {
            name.text = item.name
            status.text = item.status
            Picasso.get().load(item.image).into(image)
        }
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.drug_item, parent, false)
        return MedicationViewHolder(view)
    }

    class DrugsComparator : DiffUtil.ItemCallback<Hero>() {

        override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
            return oldItem == newItem
        }
    }
}