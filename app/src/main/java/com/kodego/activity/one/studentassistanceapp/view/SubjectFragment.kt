package com.kodego.activity.one.studentassistanceapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kodego.activity.one.studentassistanceapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SubjectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubjectFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //data from home activity

//        var subjectName: String? = intent.getStringExtra("subjectName") //>>need to add "?" to accept null inputs/values
//        var subjectDescription : String? = intent.getStringExtra("subjectDescription")
//        var imageSubject: Int = intent.getIntExtra("imageSubject",0)
//        var quantity: Int = intent.getIntExtra("quantity",0)

//        binding..setImageResource(imageSubject)
//        binding.tvSubjectName2.text = subjectName
//        binding.tvSubjectDescription2.text = subjectDescription
//        binding.tvQuantityProdDetail.text = quantity.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subject, container, false)
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