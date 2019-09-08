package com.example.simpletodo.models

import java.time.ZonedDateTime

class ToDoTask(_content: String, _completed: Boolean) {

    var content: String = _content
     private set
    var completed: Boolean = _completed
     private set

    var zonedDateTime: ZonedDateTime = ZonedDateTime.now()
    private set
}