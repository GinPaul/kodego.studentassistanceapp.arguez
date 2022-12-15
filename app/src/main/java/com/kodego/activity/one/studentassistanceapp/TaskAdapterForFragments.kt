package com.kodego.activity.one.studentassistanceapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.activity.one.studentassistanceapp.databinding.EachTodoItemBinding
import com.kodego.activity.one.studentassistanceapp.db.ToDoData

class TaskAdapterForFragments (private val list: MutableList<ToDoData>) : RecyclerView.Adapter<TaskAdapterForFragments.TaskViewHolder>(){

    private  val TAG = "TaskAdapterForFragments"
    private var listener:TaskAdapterForFragmentsInterface? = null
    fun setListener(listener:TaskAdapterForFragmentsInterface){
        this.listener = listener
    }

    class TaskViewHolder(val binding: EachTodoItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding =
            EachTodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.todoTask.text = this.task

                Log.d(TAG, "onBindViewHolder: "+this)
                binding.editTask.setOnClickListener {
                    listener?.onEditItemClicked(this , position)
                }

                binding.deleteTask.setOnClickListener {
                    listener?.onDeleteItemClicked(this , position)
                }
            }
        }
    }

    override fun getItemCount(): Int {

        //to return "list.size" only
        return list.size
    }

    //interface for the task adapter
    interface TaskAdapterForFragmentsInterface{
        fun onDeleteItemClicked(toDoData: ToDoData , position : Int)
        fun onEditItemClicked(toDoData: ToDoData , position: Int)
    }


}