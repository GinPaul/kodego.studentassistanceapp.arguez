package com.kodego.activity.one.studentassistanceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodego.activity.one.studentassistanceapp.databinding.FragmentSubjectBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SubjectFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    lateinit var binding: FragmentSubjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSubjectBinding.inflate(inflater, container, false)

        /**Inflate the layout for this fragment. Deleting this will ruin the layout!*/
        return binding.root

//        var textFromParent = arguments?.getString("data1")
        var subjectName: String? = arguments?.getString("subjectName")
        var subjectDescription : String? = arguments?.getString("subjectDescription")
        var imageSubject: Int? = arguments?.getInt("imageSubject",0)

        /**catching data from tha activity*/
        binding.tvSubjectName2.text = subjectName
        binding.tvSubjectDescription2.text = subjectDescription

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SubjectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SubjectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}