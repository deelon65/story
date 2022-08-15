package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentOnboardingUserNameBinding

class UserNameOnboardingFragment : Fragment(R.layout.fragment_onboarding_user_name) {

    private lateinit var binding: FragmentOnboardingUserNameBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingUserNameBinding.bind(view)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_userNameOnboardingFragment_to_birthdayOnboardingFragment)
        }
    }
}