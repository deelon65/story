package com.example.story.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.story.data.Orientation
import com.example.story123.databinding.ItemOrientationBinding

class OrientationAdapter(
) : RecyclerView.Adapter<OrientationAdapter.OrientationHolder>() {

    private val orientstions = mutableListOf<Orientation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrientationHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOrientationBinding.inflate(inflater, parent, false)
        return OrientationHolder(binding)
    }

    override fun onBindViewHolder(holder: OrientationHolder, position: Int) {
        val orientation = orientstions[position]
        holder.bind(orientation)
    }

    override fun getItemCount(): Int = orientstions.size

    fun setItems(items: List<Orientation>) {
        orientstions.clear()
        orientstions.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int = position

    class OrientationHolder(
        val binding: ItemOrientationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(orientation: Orientation) {
            binding.tvOrientation.text = orientation.name
        }
    }
}