package com.example.simpletodo.logic.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.R
import com.example.simpletodo.inflate
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.models.ToDoTask
import kotlinx.android.synthetic.main.clear_layout.view.*
import kotlin.collections.ArrayList

class ClearRecyclerAdapter(taskListRevealer: TaskListRevealer) : RecyclerView.Adapter<ClearRecyclerAdapter.ClearViewHolder>()   {

    val _taskListRevealer = taskListRevealer

    val toDoTasks: ArrayList<ToDoTask> = taskListRevealer.tasksBeingShown

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClearViewHolder {
        val inflatedView = parent.inflate(R.layout.clear_layout, false)
        return ClearViewHolder(inflatedView, _taskListRevealer)
    }

    override fun getItemCount(): Int {
        return toDoTasks.size
    }

    override fun onBindViewHolder(holder: ClearViewHolder, position: Int) {
        val task = toDoTasks.elementAt(position)
        holder.bindTask(task)
    }

    class ClearViewHolder(v: View, taskListRevealer: TaskListRevealer) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private val _taskListRevealer = taskListRevealer

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            _taskListRevealer.toggleChecked(this.layoutPosition)
            v.checkbox.toggle()
        }

        fun bindTask(toDoTask: ToDoTask) {
            if(toDoTask.completed) {
                view.checkbox.toggle()
            }
        }
    }

}