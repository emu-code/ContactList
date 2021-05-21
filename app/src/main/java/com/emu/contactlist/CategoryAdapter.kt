package com.emu.contactlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emu.contactlist.databinding.CategoryListItemBinding


class CategoryAdapter(private val clickListener: (Category) -> Unit ): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories = mutableListOf<Category>()

    inner class CategoryViewHolder(private val binding: CategoryListItemBinding):RecyclerView.ViewHolder(binding.root) {
            fun bind(category: Category, clickListener: (Category) -> Unit ){
                binding.categoryText.text = category.categoryType
                binding.image.setImageResource(category.categoryImg)
                binding.root.setOnClickListener { clickListener(category)}

            }
    }

    fun setUpCategory(category:List<Category>){
        this.categories.addAll(category)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryListItemBinding.inflate
        (LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val binder = categories[position]
        holder.bind(binder,clickListener)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}