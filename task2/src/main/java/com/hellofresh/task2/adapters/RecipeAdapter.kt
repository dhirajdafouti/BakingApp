package com.hellofresh.task2.adapters

import com.hellofresh.task2.databinding.FragmentItemRowBinding
import com.hellofresh.task2.domainmodel.RecipeUIData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


/**
 * Adapter class which will display the list of Recipe to the Recycler View.
 */

class RecipeAdapter :
    ListAdapter<RecipeUIData, RecipeAdapter.ViewHolder>(AsteroidDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userData = getItem(position)
        holder.bind(userData!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class AsteroidDiffCallback : DiffUtil.ItemCallback<RecipeUIData>() {
        override fun areItemsTheSame(oldItem: RecipeUIData, newItem: RecipeUIData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecipeUIData, newItem: RecipeUIData): Boolean {
            return oldItem == newItem
        }

    }

    class ViewHolder private constructor(val binding: FragmentItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            userData: RecipeUIData,
        ) {
            binding.recipeData = userData
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentItemRowBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}
