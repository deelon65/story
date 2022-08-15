package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentOnboardingBirthdayBinding

class BirthdayOnboardingFragment : Fragment(R.layout.fragment_onboarding_birthday) {

    private lateinit var binding: FragmentOnboardingBirthdayBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingBirthdayBinding.bind(view)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_birthdayOnboardingFragment_to_sexOnboardingFragment)
        }
    }
}