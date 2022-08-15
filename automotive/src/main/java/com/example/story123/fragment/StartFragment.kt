package com.example.story.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.story123.R
import com.example.story123.databinding.FragmentStartBinding


class StartFragment : Fragment(R.layout.fragment_start) {

    private lateinit var binding: FragmentStartBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStartBinding.bind(view)

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_registrationFragment)
        }

        binding.btnEnter.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_authorizationFragment)
        }
    }

}