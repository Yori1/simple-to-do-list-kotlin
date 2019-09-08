package com.example.simpletodo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simpletodo.logic.TaskListRevealer
import com.example.simpletodo.logic.adapters.ClearRecyclerAdapter
import com.example.simpletodo.logic.adapters.TaskRecyclerAdapter
import com.example.simpletodo.models.ToDoTask

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private var taskListRevealer = TaskListRevealer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerViewTasks: RecyclerView = findViewById(R.id.recyclerViewTasks)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerViewTasks.layoutManager = linearLayoutManager




        recyclerViewTasks.adapter = TaskRecyclerAdapter(taskListRevealer.tasksBeingShown)



        taskListRevealer.addTask(ToDoTask("task", false))


    }


}
