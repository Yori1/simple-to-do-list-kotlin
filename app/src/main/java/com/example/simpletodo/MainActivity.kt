package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.logic.adapters.TaskRecyclerAdapter
import com.example.simpletodo.models.ToDoTask

class MainActivity : AppCompatActivity() {

    private val taskListRevealer: TaskListRevealer = TaskListRevealer()
    private lateinit var linearLayoutManagerTasks: LinearLayoutManager

    private lateinit var recyclerViewTasks: RecyclerView
    private lateinit var  taskAdapter : TaskRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)

        linearLayoutManagerTasks = LinearLayoutManager(this)
        recyclerViewTasks.layoutManager = linearLayoutManagerTasks

        taskAdapter = TaskRecyclerAdapter(taskListRevealer.tasksBeingShown)
        recyclerViewTasks.adapter = taskAdapter


        taskListRevealer.addTask(ToDoTask("task", false))


    }


}
