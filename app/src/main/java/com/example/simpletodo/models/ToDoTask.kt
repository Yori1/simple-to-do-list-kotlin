package com.example.simpletodo.models

class ToDoTask(_content: String, _completed: Boolean) {

    var content: String = _content
     private set
    var completed: Boolean = _completed
     private set
}