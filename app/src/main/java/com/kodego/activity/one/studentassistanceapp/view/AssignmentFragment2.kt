package com.kodego.activity.one.studentassistanceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodego.activity.one.studentassistanceapp.databinding.FragmentAssignment2Binding

class AssignmentFragment2 : Fragment() {

    lateinit var binding: FragmentAssignment2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAssignment2Binding.inflate(layoutInflater)

        return binding.root
    }

}