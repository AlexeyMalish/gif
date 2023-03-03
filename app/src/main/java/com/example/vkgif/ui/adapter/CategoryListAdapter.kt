package com.example.vkgif.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vkgif.ui.CellClickListener
import com.example.vkgif.data.Category
import com.example.vkgif.databinding.CategoryItemBinding

class CategoryListAdapter(
    val mCategoryList: List<Category>,
    private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<CategoryListAdapter.CategoryListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        return CategoryListViewHolder(
            CategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        val categoryItem = mCategoryList[position]
        holder.bindData(categoryItem)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(categoryItem.name)
        }
    }

    override fun getItemCount(): Int {
        return mCategoryList.size
    }

    class CategoryListViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(category: Category) {
            binding.categoryItemTv.text = category.name
        }

    }
}