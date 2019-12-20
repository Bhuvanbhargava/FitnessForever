package edu.bellevue.bhuvan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import edu.bellevue.bhuvan.databinding.FragmentWeightEntryBinding


class WeightEntryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentWeightEntryBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_weight_entry,container,false)
        binding.idCancelEntry.setOnClickListener{ view -> Navigation.findNavController(view).navigate(R.id.action_weightEntryFragment_to_weightSummaryFragment2)}
        return binding.root

    }

}
