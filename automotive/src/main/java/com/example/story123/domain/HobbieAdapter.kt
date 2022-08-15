package com.example.story.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.story.data.Hobbie
import com.example.story123.databinding.ItemHobbieBinding


class HobbieAdapter(
) : RecyclerView.Adapter<HobbieAdapter.HobbieHolder>() {

    private lateinit var onHobbieClickListener: (position: Int) -> Unit
    private val hobbies = mutableListOf<Hobbie>()

    fun setOnHobbieClickListener(onHobbieClickListener: (position: Int) -> Unit) {
        this.onHobbieClickListener = onHobbieClickListener
    }

    fun changeHobbieState(position: Int) {
        notifyItemChanged(position)
    }

    fun setUpdateItemsHobbie(items: List<Hobbie>) {
        hobbies.clear()
        hobbies.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHobbieBinding.inflate(inflater, parent, false)
        return HobbieHolder(binding)
    }

    override fun onBindViewHolder(holder: HobbieHolder, position: Int) {

        val hobbie = hobbies[position]
        holder.bind(hobbie)
        holder.apply {
            itemView.setOnClickListener {
                onHobbieClickListener(position)
            }
        }
    }

    override fun getItemCount(): Int = hobbies.size

    class HobbieHolder(
        val binding: ItemHobbieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hobbie: Hobbie) {
            binding.tvHobbie.text = hobbie.name
            binding.tvHobbie.setBackgroundResource(hobbie.lineColor)
            binding.tvHobbie.setTextColor(hobbie.textColor)
        }
    }
}