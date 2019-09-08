package com.example.simpletodo.logic

import com.example.simpletodo.models.ToDoTask

class TaskListRevealer {

    var tasksBeingShown = ArrayList<ToDoTask>()
        private set

    private val allTasks = ArrayList<ToDoTask>()

    private var showAddedTasks = true

    fun addTask(task: ToDoTask) {
        allTasks.add(task)
        if(showAddedTasks) {
            tasksBeingShown.add(task)
        }
    }

    fun deleteTask(index: Int) {
        tasksBeingShown.removeAt(index)
        allTasks.removeAt(index)
    }

    fun showAll() {
        tasksBeingShown.clear()
        allTasks.forEach{ t -> tasksBeingShown.add(t) }
        showAddedTasks = true
    }

    fun showCompleted() {
        tasksBeingShown.clear()
        allTasks
            .filter { t -> t.completed }
            .forEach { t -> tasksBeingShown.add(t)}
        showAddedTasks = true
    }

    fun showActive() {
        tasksBeingShown.clear()
        allTasks
            .filter { t -> tasksBeingShown.add(t) }
        showAddedTasks = false
    }

}