package edu.bellevue.bhuvan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import edu.bellevue.bhuvan.databinding.FragmentWeightSummaryBinding

class WeightSummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title="Fitness Forever"
        // Inflate the layout for this fragment
        val binding: FragmentWeightSummaryBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_weight_summary, container, false)
        binding.idBtnEntry.setOnClickListener{ view -> Navigation.findNavController(view).navigate(R.id.action_weightSummaryFragment2_to_weightEntryFragment)}

        return binding.root
    }

}
