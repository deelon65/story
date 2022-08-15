package com.example.story.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.story123.R
import com.example.story.data.Hobbie
import com.example.story123.databinding.FragmentOnboardingHobbieBinding
import com.example.story.domain.HobbieAdapter

class HobbieOnboardingFragment : Fragment(R.layout.fragment_onboarding_hobbie) {

    private val hobbies: MutableList<Hobbie> by lazy { getHobbieList() }
    private val hobbiesAdapter: HobbieAdapter by lazy { HobbieAdapter() }

    private var selectHobbiesCount : Short = 0

    private lateinit var binding: FragmentOnboardingHobbieBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentOnboardingHobbieBinding.bind(view)

        val layoutManager = LinearLayoutManager(context)
        binding.hobbiesRV.layoutManager = layoutManager
        binding.hobbiesRV.adapter = hobbiesAdapter
        hobbiesAdapter.setUpdateItemsHobbie(hobbies)
        binding.btnContinues.text = "ПРОДОЛЖИТЬ $MIN_SELECT_HOBBIES_COUNT/$MAX_SELECT_HOBBIES_COUNT"
        hobbiesAdapter.setOnHobbieClickListener { position ->
            val clickedHobbie = hobbies[position]
            if (clickedHobbie.isSelect) {
                selectHobbiesCount--
                clickedHobbie.isSelect = false
                clickedHobbie.lineColor = R.drawable.ic_hobbie_delete
                clickedHobbie.textColor = Color.WHITE
            } else {
                if(selectHobbiesCount < MAX_SELECT_HOBBIES_COUNT) {
                    selectHobbiesCount++
                    clickedHobbie.isSelect = true
                    clickedHobbie.lineColor = R.drawable.ic_hobbie_done
                    clickedHobbie.textColor = Color.MAGENTA
                }
            }

            binding.btnContinues.text = "ПРОДОЛЖИТЬ $selectHobbiesCount/$MAX_SELECT_HOBBIES_COUNT"
            hobbiesAdapter.setUpdateItemsHobbie(hobbies)
            hobbiesAdapter.changeHobbieState(position)
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvMiss.setOnClickListener {
            findNavController().navigate(R.id.action_hobbieOnboardingFragment_to_imageSelectionOnboardingFragment)
        }

        binding.btnContinues.setOnClickListener {
            findNavController().navigate(R.id.action_hobbieOnboardingFragment_to_imageSelectionOnboardingFragment)
        }

    }

    fun getHobbieList(): MutableList<Hobbie> {
        val hobbiesName = resources.getStringArray(R.array.hobbieRV)
        val hobbies = mutableListOf<Hobbie>()
        hobbiesName.forEach { name ->
            hobbies.add(Hobbie(name))
        }
        return hobbies
    }

    private companion object{
        const val MIN_SELECT_HOBBIES_COUNT = 0
        const val MAX_SELECT_HOBBIES_COUNT = 5
    }
}