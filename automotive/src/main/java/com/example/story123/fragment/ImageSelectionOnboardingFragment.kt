package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentOnboardingImageSelectionBinding

class ImageSelectionOnboardingFragment : Fragment(R.layout.fragment_onboarding_image_selection) {

    private lateinit var binding: FragmentOnboardingImageSelectionBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingImageSelectionBinding.bind(view)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {

        }
    }
}