package com.example.story.domain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.story.data.Rule
import com.example.story123.databinding.ItemRulesBinding

class RulesAdapter(
) : RecyclerView.Adapter<RulesAdapter.RulesHolder>() {

    private val rules = mutableListOf<Rule>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RulesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRulesBinding.inflate(inflater, parent, false)
        return RulesHolder(binding)
    }

    override fun onBindViewHolder(holder: RulesHolder, position: Int) {
        val rule = rules[position]
        holder.bind(rule)
    }

    override fun getItemCount(): Int = rules.size

    fun setItems(items: List<Rule>) {
        rules.clear()
        rules.addAll(items)
        notifyDataSetChanged()
    }

    class RulesHolder(
        val binding: ItemRulesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(rules: Rule) {
            binding.tvRuleHeader.text = rules.header
            binding.tvRule.text = rules.name
        }
    }

}