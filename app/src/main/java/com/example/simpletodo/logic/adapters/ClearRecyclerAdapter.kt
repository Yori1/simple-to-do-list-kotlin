package com.example.simpletodo.logic.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.R
import com.example.simpletodo.inflate
import com.example.simpletodo.logic.Observer
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.models.ToDoTask
import kotlinx.android.synthetic.main.clear_layout.view.*
import kotlin.collections.ArrayList

class ClearRecyclerAdapter(taskListRevealer: TaskListRevealer) : RecyclerView.Adapter<ClearRecyclerAdapter.ClearViewHolder>(), Observer   {

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

    override fun update() {
        this.notifyDataSetChanged()
    }

    class ClearViewHolder(v: View, taskListRevealer: TaskListRevealer) : RecyclerView.ViewHolder(v), View.OnClickListener, Observer {
        private var view: View = v
        private val _taskListRevealer = taskListRevealer
        private var task: ToDoTask? = null

        init {
            v.checkbox.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            _taskListRevealer.toggleChecked(this.layoutPosition)
        }

        fun bindTask(toDoTask: ToDoTask) {
            view.checkbox.setChecked(toDoTask.completed)
            task = toDoTask
        }

        override fun update() {
            val localTask = task;
            if(localTask != null) {
                view.checkbox.setChecked(localTask.completed)
            }

        }


    }

}