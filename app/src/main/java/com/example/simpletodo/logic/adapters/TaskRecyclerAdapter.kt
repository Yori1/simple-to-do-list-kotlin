package com.example.simpletodo.logic.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.R
import com.example.simpletodo.inflate
import com.example.simpletodo.logic.Observer
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.models.ToDoTask
import kotlinx.android.synthetic.main.task_layout.view.*

class TaskRecyclerAdapter(taskListRevealer: TaskListRevealer) : RecyclerView.Adapter<TaskRecyclerAdapter.ToDoTaskHolder>(), Observer  {
    private var _taskListRevealer: TaskListRevealer = taskListRevealer
    private var toDoTasks: ArrayList<ToDoTask> = _taskListRevealer.tasksBeingShown

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoTaskHolder {
        val inflatedView = parent.inflate(R.layout.task_layout, false)
        return ToDoTaskHolder(inflatedView, _taskListRevealer)
    }

    override fun getItemCount(): Int {
        return toDoTasks.count()
    }

    override fun onBindViewHolder(holder: ToDoTaskHolder, position: Int) {
        val task = toDoTasks.elementAt(position)
        holder.bindTask(task)
    }

    override fun update() {
        this.notifyDataSetChanged()
    }

    class ToDoTaskHolder(v: View, taskListRevealer: TaskListRevealer) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var task: ToDoTask? = null
        private var _taskListRevealer = taskListRevealer

        init {
            v.checkbox.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            _taskListRevealer.toggleChecked(this.layoutPosition)
        }

        fun bindTask(toDoTask: ToDoTask) {
            this.task = toDoTask
            val localTask = task;
            if(localTask != null) {
                view.checkbox.setChecked(localTask.completed)
            }
            view.textView.text = toDoTask.content
        }

        fun update() {
            val localTask = task;
            if(localTask != null) {
                view.checkbox.setChecked(localTask.completed)
            }
        }


    }

}