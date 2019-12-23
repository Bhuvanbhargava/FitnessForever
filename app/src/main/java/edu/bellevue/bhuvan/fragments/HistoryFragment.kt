package edu.bellevue.bhuvan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import edu.bellevue.bhuvan.history.WeightHistoryViewModal
import edu.bellevue.bhuvan.history.WeightHistoryViewModalFactory
import edu.bellevue.bhuvan.R
import edu.bellevue.bhuvan.database.AppDatabase
import edu.bellevue.bhuvan.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title="History"
         binding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_history,container,false)
        val application = requireNotNull(activity).application
        val dataSource = AppDatabase.getInstance(application).weightDao()
        val viewModelFactory= WeightHistoryViewModalFactory(dataSource,application)
        val weightHistoryViewModel = ViewModelProvider(this,viewModelFactory).get(
            WeightHistoryViewModal::class.java)


        binding.weightHistoryViewModel=weightHistoryViewModel
        binding.lifecycleOwner=this
        return binding.root;
    }

    
}
