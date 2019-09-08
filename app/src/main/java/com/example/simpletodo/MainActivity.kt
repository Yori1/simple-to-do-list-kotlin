package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.logic.adapters.ClearRecyclerAdapter
import com.example.simpletodo.logic.adapters.TaskRecyclerAdapter
import com.example.simpletodo.models.ToDoTask
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val taskListRevealer: TaskListRevealer = TaskListRevealer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareTaskRecyclerView()
        prepareClearRecyclerView()


        taskListRevealer.addTask(ToDoTask("task", false))
        taskListRevealer.addTask(ToDoTask("task", false))

        taskListRevealer.addTask(ToDoTask("task", false))

    }

    fun onClick(v: View) {
        when (v.getId()) {

        }//.... etc
    }

    fun prepareTaskRecyclerView() {
        val recyclerViewTasks: RecyclerView = findViewById(R.id.recyclerViewTasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = TaskRecyclerAdapter(taskListRevealer.tasksBeingShown)
    }

    fun prepareClearRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewClear)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ClearRecyclerAdapter(taskListRevealer)
    }



}
