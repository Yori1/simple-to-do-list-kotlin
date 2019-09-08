package com.example.simpletodo

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.models.ToDoTask

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ToDoTaskHolder>()  {
    private lateinit var toDoTasks: ArrayList<ToDoTask>;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ToDoTaskHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ToDoTaskHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //1
    class ToDoTaskHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var photo: ToDoTask? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private val TASK_KEY = "TASK"
        }
    }

}