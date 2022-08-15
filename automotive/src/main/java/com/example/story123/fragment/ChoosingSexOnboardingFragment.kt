package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentOnboardingChoosingSexBinding

class ChoosingSexOnboardingFragment : Fragment(R.layout.fragment_onboarding_choosing_sex) {

    private lateinit var binding: FragmentOnboardingChoosingSexBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingChoosingSexBinding.bind(view)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_choosingSexOnboardingFragment_to_schoolOnboardingFragment)
        }
    }
}