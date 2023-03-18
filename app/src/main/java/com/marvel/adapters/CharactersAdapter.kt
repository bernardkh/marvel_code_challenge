package com.marvel.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marvel.R
import com.marvel.beans.Results
import com.marvel.config.Constants
import com.marvel.databinding.ItemCharacterBinding
import com.marvel.ui.CharacterDetailsActivity

class CharactersAdapter(DataArrayList: ArrayList<Results>) :
    RecyclerView.Adapter<CharactersAdapter.MyViewHolder>() {
    var DataArrayList: ArrayList<Results>

    init {
        this.DataArrayList = DataArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemCharacterBinding = ItemCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = DataArrayList[position]
        holder.name.text = item.name
        holder.description.text = item.description

        if (item.thumbnail != null && item.thumbnail.path != null
            && item.thumbnail.extension != null)
        {
            val path: String = item.thumbnail.path
            val extension: String = item.thumbnail.extension
            Glide.with(holder.itemView.context)
                .load("$path.$extension")
                .placeholder(R.drawable.marvel)
                .into(holder.image)
        }
        else
            holder.image.setImageResource(R.drawable.marvel)


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, CharacterDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putString(
                Constants.CharacterID,
                DataArrayList[holder.adapterPosition].id.toString()
            )
            bundle.putString(Constants.CharacterName,
            DataArrayList[holder.adapterPosition].name.toString())
            intent.putExtras(bundle)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return DataArrayList.size
    }

    inner class MyViewHolder(itemList: ItemCharacterBinding) : RecyclerView.ViewHolder(itemList.root) {
        var name: TextView
        var description: TextView
        var image: ImageView
        var ivArrow :ImageView

        init {
            name = itemList.txName
            description = itemList.txDescription
            image = itemList.characterImg
            ivArrow = itemList.ivArrow
        }
    }
}