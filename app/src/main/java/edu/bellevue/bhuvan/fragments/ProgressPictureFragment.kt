package edu.bellevue.bhuvan.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.bellevue.bhuvan.R

class ProgressPictureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        activity?.title="Progress"
        return inflater.inflate(R.layout.fragment_progress_picture, container, false)
    }

}
