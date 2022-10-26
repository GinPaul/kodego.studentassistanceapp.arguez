package com.kodego.activity.one.studentassistanceapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.activity.one.studentassistanceapp.databinding.StudentActivityBinding

class SubjectAdapter (val products: MutableList<Subjects>): RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder>() {


    var onItemClick: ((Subjects) -> Unit)? = null
    var onUpdateButtonClick: ((Subjects, Int) -> Unit)? = null
    var onDeleteButtonClick: ((Subjects, Int) -> Unit)? = null

    inner class SubjectViewHolder(val binding: StudentActivityBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = StudentActivityBinding.inflate(layoutInflater, parent, false)
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {

        //holder.binding.imgProduct.setImageResource() << old method
        holder.binding.apply {
            imgSubject.setImageResource(products[position].imageSubject)
            tvSubjectName.text = products[position].subjectName
            tvSubjectDescription.text = products[position].subjectDescription
            tvSubjectNumber.text = products[position].subjectNumber.toString()
//            imgBtnUpdate.setOnClickListener(){
//                onUpdateButtonClick?.invoke(products[position],position)
//            }
//            imgBtnDelete.setOnClickListener(){
//                onDeleteButtonClick?.invoke(products[position],position)
//            }
        }
        holder.itemView.setOnClickListener(){
            onItemClick?.invoke(products[position])
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}