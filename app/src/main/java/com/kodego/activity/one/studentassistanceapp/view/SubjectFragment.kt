package com.kodego.activity.one.studentassistanceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodego.activity.one.studentassistanceapp.databinding.FragmentSubjectBinding

class SubjectFragment : Fragment() {

    lateinit var binding: FragmentSubjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSubjectBinding.inflate(inflater, container, false)

//        var textFromParent = arguments?.getString("data1")
        var subjectName: String? = arguments?.getString("subjectName")
        var subjectDescription : String? = arguments?.getString("subjectDescription")
        var imageSubject: Int? = arguments?.getInt("imageSubject",0)

        /**catching data from the activity*/
        binding.tvSubjectName2.text = subjectName
        binding.tvSubjectDescription2.text = subjectDescription

        /**Inflate the layout for this fragment. Deleting this will ruin the layout!*/
        return binding.root

    }

}