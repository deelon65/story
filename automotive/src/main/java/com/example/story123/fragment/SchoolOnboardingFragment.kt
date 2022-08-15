package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentOnboardingSchoolBinding

class SchoolOnboardingFragment : Fragment(R.layout.fragment_onboarding_school) {

    private lateinit var binding: FragmentOnboardingSchoolBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingSchoolBinding.bind(view)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_schoolOnboardingFragment_to_hobbieOnboardingFragment)
        }

        binding.tvMiss.setOnClickListener {
            findNavController().navigate(R.id.action_schoolOnboardingFragment_to_hobbieOnboardingFragment)
        }
    }

}