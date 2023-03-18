package com.marvel.adapters.all

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marvel.R
import com.marvel.adapters.single.CategoryAdapter
import com.marvel.databinding.ItemListCategoryBinding

class AllCategoriesAdapter (DataArrayList: ArrayList<AllCategories>) :
    RecyclerView.Adapter<AllCategoriesAdapter.MyViewHolder>() {

    private var dataArrayList: ArrayList<AllCategories>

    init {
        this.dataArrayList = DataArrayList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding: ItemListCategoryBinding = ItemListCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataArrayList[position]
        holder.txTitle.text = item.title

        holder.allCategoriesRecyclerView.layoutManager = LinearLayoutManager(holder.itemView.context,
        LinearLayoutManager.HORIZONTAL,false)

        val categoryAdapter = CategoryAdapter(item.categories)
        holder.allCategoriesRecyclerView.adapter=categoryAdapter

    }

    override fun getItemCount(): Int {
        return dataArrayList.size
    }


    class MyViewHolder(itemList: ItemListCategoryBinding) : RecyclerView.ViewHolder(itemList.root) {
        var allCategoriesRecyclerView:RecyclerView
        var txTitle:TextView
        init {
            allCategoriesRecyclerView = itemList.allCategoriesListview
            txTitle = itemList.txTitle
        }
    }
}