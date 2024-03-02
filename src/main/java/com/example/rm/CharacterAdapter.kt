package com.example.rm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: CharacterResponse) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun getItemViewType(position: Int): Int {
        if (characters.results[position].getType() == "image") {
            return R.layout.character_image
        } else if (characters.results[position].getType() == "name") {
            return R.layout.character_name
        } else return R.layout.character_species
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        if (viewType == R.layout.character_image) {
            return ImageViewHolder(view)
        } else if (viewType == R.layout.character_name) {
            return NameViewHolder(view)
        } else return SpeciesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ImageViewHolder) {
            holder.bind(characters.results[position])
        } else if (holder is NameViewHolder) {
            holder.bind(characters.results[position])
        } else (holder as SpeciesViewHolder).bind(characters.results[position])
    }

    override fun getItemCount(): Int {
        return characters.results.size
    }

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var imageView: ImageView = view.findViewById(R.id.tw_image)

        fun bind(character: Character) {
            Picasso.get()
                .load(character.image)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }

    class NameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.tw_name)

        fun bind(character: Character) {
            textView.text = character.name
        }
    }

    class SpeciesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.tw_species)

        fun bind(character: Character) {
            textView.text = character.species
        }
    }
}
