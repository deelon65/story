package com.example.story.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.story123.R
import com.example.story.data.Orientation
import com.example.story123.databinding.FragmentOnboardingOrientationBinding
import com.example.story.domain.OrientationAdapter

class OrientationOnboardingFragment : Fragment(R.layout.fragment_onboarding_orientation) {

    private val orientations: List<Orientation> by lazy { getOrientationList() }
    private val orientationsAdapter: OrientationAdapter by lazy { OrientationAdapter() }

    private lateinit var binding: FragmentOnboardingOrientationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOnboardingOrientationBinding.bind(view)

        val layoutManager = LinearLayoutManager(context)
        binding.orientarionRV.layoutManager = layoutManager
        binding.orientarionRV.adapter = orientationsAdapter
        orientationsAdapter.setItems(orientations)

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_orientationOnboardingFragment_to_choosingSexOnboardingFragment)
        }

        binding.tvMiss.setOnClickListener {
            findNavController().navigate(R.id.action_orientationOnboardingFragment_to_choosingSexOnboardingFragment)
        }
    }

    private fun getOrientationList(): MutableList<Orientation> {
        val orientationsName = resources.getStringArray(R.array.orientationRV)
        val orientations = mutableListOf<Orientation>()
        orientationsName.forEach { name ->
            orientations.add(Orientation(name))
        }
        return orientations
    }
}