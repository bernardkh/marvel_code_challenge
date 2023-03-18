package com.marvel.adapters.single

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marvel.beans.Results
import com.marvel.R
import com.marvel.databinding.ItemCategoryBinding

class CategoryAdapter (DataArrayList: ArrayList<Results>) :
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    var DataArrayList: ArrayList<Results>

    init {
        this.DataArrayList = DataArrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemCategoryBinding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return DataArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = DataArrayList[position]
        holder.txTitle.text = item.title
        holder.txDescription.text = item.description

            if (item.thumbnail != null && item.thumbnail.path != null && item.thumbnail.extension != null) {
                val path: String = item.thumbnail.path
                val extension: String = item.thumbnail.extension

                Glide.with(holder.itemView.context)
                    .load("$path.$extension")
                    .placeholder(R.drawable.marvel)
                    .into(holder.characterImg)
            } else
                holder.characterImg.setImageResource(R.drawable.marvel)
    }

    class MyViewHolder(itemCategory: ItemCategoryBinding) : RecyclerView.ViewHolder(itemCategory.root) {
        var characterImg:ImageView
        var txTitle:TextView
        var txDescription:TextView

        init {
            characterImg = itemCategory.characterImg
            txTitle = itemCategory.txTitle
            txDescription = itemCategory.txDescription

        }
    }

}