package edu.bellevue.bhuvan

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import android.database.sqlite.SQLiteDatabase
import androidx.navigation.Navigation
import edu.bellevue.bhuvan.databinding.FragmentWeightEntryBinding


class WeightEntryFragment : Fragment() {
    private lateinit var db: SQLiteDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title="Record Weight"
        val binding : FragmentWeightEntryBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_weight_entry,container,false)
        binding.idCancelEntry.setOnClickListener{ view -> Navigation.findNavController(view).navigate(R.id.action_weightEntryFragment_to_weightSummaryFragment2)}

        binding.idSaveEntry.setOnClickListener {
            if (binding.editText.toString().trim().isEmpty() ||
                binding.idWeight.toString().trim().isEmpty()
            ) {
                val toast = Toast.makeText(applicationContext, "Please enter all values", Toast.LENGTH_LONG)
                toast.show()
            }
            db.execSQL(
                "INSERT INTO Weight VALUES('" + binding.editText.toString().trim().isEmpty() + "','" + editName.text +
                        "','" + editMarks.text + "');"
            );
        return binding.root

    }

}
