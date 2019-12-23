package edu.bellevue.bhuvan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import edu.bellevue.bhuvan.R
import edu.bellevue.bhuvan.convertDateStringToLong
import edu.bellevue.bhuvan.database.AppDatabase
import edu.bellevue.bhuvan.database.Weight
import edu.bellevue.bhuvan.databinding.FragmentWeightEntryBinding
import edu.bellevue.bhuvan.weighttracker.WeightTrackerViewModal


import edu.bellevue.bhuvan.weighttracker.WeightTrackerViewModalFactory


class WeightEntryFragment : Fragment() {
    lateinit var  binding :FragmentWeightEntryBinding;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title="Record Weight"
        binding  = DataBindingUtil.inflate(inflater,
             R.layout.fragment_weight_entry,container,false)
        binding.idCancelEntry.setOnClickListener{ view -> Navigation.findNavController(view).navigate(
            R.id.action_weightEntryFragment_to_weightSummaryFragment2
        )}
        binding.idSaveEntry.setOnClickListener{ view ->

            Navigation.findNavController(view).navigate(
            R.id.action_weightEntryFragment_to_weightSummaryFragment2
        )}
        val weightVal= binding.idWeight.text.toString()
        val dateVal=binding.editText.text.toString()
        var date= convertDateStringToLong(dateVal)
        binding.weight= Weight(weight = weightVal,date = date)
        val application = requireNotNull(activity).application
        val dataSource = AppDatabase.getInstance(application).weightDao()
        val viewModelFactory= WeightTrackerViewModalFactory(dataSource,application,weightVal,dateVal)
        val weightTrackerViewModel =ViewModelProvider(this,viewModelFactory).get(
            WeightTrackerViewModal::class.java)
        binding.weightTrackerViewModel=weightTrackerViewModel
        binding.lifecycleOwner=this

        return binding.root

    }




}
