package com.example.simpletodo

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.models.ToDoTask
import kotlinx.android.synthetic.main.task_layout.view.*

class RecyclerAdapter(_toDoTasks: ArrayList<ToDoTask>) : RecyclerView.Adapter<RecyclerAdapter.ToDoTaskHolder>()  {
    private var toDoTasks: ArrayList<ToDoTask> = _toDoTasks

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ToDoTaskHolder {
        val inflatedView = parent.inflate(R.layout.task_layout, false)
        return ToDoTaskHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return toDoTasks.count()
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ToDoTaskHolder, position: Int) {
        val task = toDoTasks.elementAt(position)
        holder.bindTask(task)
    }

    class ToDoTaskHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var task: ToDoTask? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindTask(toDoTask: ToDoTask) {
            this.task = toDoTask
            view.textView.text = toDoTask.content
        }
    }

}