package com.example.simpletodo.logic.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.R
import com.example.simpletodo.inflate
import com.example.simpletodo.logic.Observer
import com.example.simpletodo.models.ToDoTask
import kotlinx.android.synthetic.main.clear_layout.view.*
import kotlinx.android.synthetic.main.task_layout.view.*
import java.util.logging.Logger

class TaskRecyclerAdapter(_toDoTasks: ArrayList<ToDoTask>) : RecyclerView.Adapter<TaskRecyclerAdapter.ToDoTaskHolder>(), Observer  {
    private var toDoTasks: ArrayList<ToDoTask> = _toDoTasks

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoTaskHolder {
        val inflatedView = parent.inflate(R.layout.task_layout, false)
        return ToDoTaskHolder(
            inflatedView
        )
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

    class ToDoTaskHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var task: ToDoTask? = null

        init {
            v.setOnClickListener(this)

        }

        override fun onClick(v: View) {
            Log.e("a","click")
        }

        fun bindTask(toDoTask: ToDoTask) {
            this.task = toDoTask
            view.textView.text = toDoTask.content
        }


    }

}