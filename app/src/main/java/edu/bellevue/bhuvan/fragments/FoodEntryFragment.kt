package edu.bellevue.bhuvan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import edu.bellevue.bhuvan.R
import edu.bellevue.bhuvan.databinding.FragmentFoodEntryBinding



class FoodEntryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title="Record Calories"

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_food_entry, container, false)
        val binding : FragmentFoodEntryBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_weight_entry,container,false)
        binding.feCancel.setOnClickListener{ view -> Navigation.findNavController(view).navigate(
            R.id.action_foodEntryFragment_to_weightSummaryFragment2
        )}
        binding.feSave.setOnClickListener{ view -> Navigation.findNavController(view).navigate(
            R.id.action_foodEntryFragment_to_weightSummaryFragment2
        )}

        return binding.root

    }


}
