package com.example.story.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.story123.R
import com.example.story.data.Rule
import com.example.story123.databinding.FragmentOnboardingWelcomeBinding
import com.example.story.domain.RulesAdapter

class WelcomeOnboardingFragment : Fragment(R.layout.fragment_onboarding_welcome) {

    private val rules: List<Rule> by lazy { getRulesList() }
    private val rulesAdapter: RulesAdapter by lazy { RulesAdapter() }

    private lateinit var binding: FragmentOnboardingWelcomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentOnboardingWelcomeBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        binding.rulesRV.layoutManager = layoutManager
        binding.rulesRV.adapter = rulesAdapter
        rulesAdapter.setItems(rules)

        binding.ivExit.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnAccept.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeOnboardingFragment_to_userNameOnboardingFragment)
        }
    }

    private fun getRulesList(): MutableList<Rule> {
        val rulesHeader = resources.getStringArray(R.array.headerRulesRV)
        val rulesName = resources.getStringArray(R.array.rulesRV)
        val rules = mutableListOf<Rule>()
        rulesName.forEachIndexed { index, subTitle ->
            rules.add(Rule(rulesHeader[index], subTitle))
        }
        return rules
    }
}