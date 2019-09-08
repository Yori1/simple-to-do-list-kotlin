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
import android.widget.EditText
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

    private val taskListRevealer: TaskListRevealer = TaskListRevealer()
    private val taskRecycleAdapter = TaskRecyclerAdapter(taskListRevealer.tasksBeingShown)
    private val clearRecyclerAdapter = ClearRecyclerAdapter(taskListRevealer)
    private var  editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepareTaskRecyclerView()
        prepareClearRecyclerView()

        val buttonAll = findViewById<Button>(R.id.button_all)
        val buttonActive = findViewById<Button>(R.id.button_active)
        val buttonCompleted = findViewById<Button>(R.id.button_completed)
        val imageViewAdd = findViewById<ImageView>(R.id.imageViewAdd)
        editText = findViewById<EditText>(R.id.editText)

        imageViewAdd.setOnClickListener {
            val editTextLocal = editText
            if(editTextLocal != null) {
                taskListRevealer.addTask(ToDoTask(editTextLocal.text.toString(), false))
            }
        }

        buttonAll.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                taskListRevealer.showAll()
            }
        })

        buttonActive.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                taskListRevealer.showActive()
            }
        })

        buttonCompleted.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                taskListRevealer.showCompleted()
            }
        })

    }

    fun prepareTaskRecyclerView() {
        taskListRevealer.subscribe(taskRecycleAdapter)
        val recyclerViewTasks: RecyclerView = findViewById(R.id.recyclerViewTasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = taskRecycleAdapter
    }

    fun prepareClearRecyclerView() {
        taskListRevealer.subscribe(clearRecyclerAdapter)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewClear)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = clearRecyclerAdapter
    }


}
