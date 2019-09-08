package com.example.simpletodo.logic

import com.example.simpletodo.models.Mode
import com.example.simpletodo.models.ToDoTask

class TaskListRevealer(): Observable() {

    var tasksBeingShown = ArrayList<ToDoTask>()
        private set

    private val allTasks = ArrayList<ToDoTask>()

    private var mode: Mode = Mode.All

    fun addTask(task: ToDoTask) {
        allTasks.add(task)
        if(mode == Mode.All || mode == Mode.Active) {
            tasksBeingShown.add(task)
        }
    }

    fun deleteTask(index: Int) {
        val taskToRemove = tasksBeingShown.elementAtOrNull(index)
        if(taskToRemove!=null) {
            tasksBeingShown.removeAt(index)
            allTasks.remove(taskToRemove)
        }
    }

    fun toggleChecked(index: Int) {
        val task = tasksBeingShown.elementAtOrNull(index)
        if(task != null ) {
            task.toggleClear()
            if(task.completed) {
                if(mode == Mode.Active) {
                    tasksBeingShown.remove(task)
                }
            }

            else {
                if(mode == Mode.Completed) {
                    tasksBeingShown.remove(task)
                }
            }
        }
        notifyObservers()
    }

    fun showAll() {
        tasksBeingShown.clear()
        allTasks.forEach{ t -> tasksBeingShown.add(t) }
        mode = Mode.All
        notifyObservers()
    }

    fun showCompleted() {
        tasksBeingShown.clear()
        allTasks
            .filter { t -> t.completed }
            .forEach { t -> tasksBeingShown.add(t)}
        mode = Mode.Completed
        notifyObservers()
    }

    fun showActive() {
        tasksBeingShown.clear()
        allTasks
            .filter { t -> !t.completed }
            .forEach{ t -> tasksBeingShown.add(t) }
        mode = Mode.Active
        notifyObservers()
    }

}