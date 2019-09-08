package com.example.simpletodo.logic


abstract class Observable {
    private val _observers = ArrayList<Observer>()

    protected fun notifyObservers() {
        _observers.forEach{o -> o.update()}
    }

    fun subscribe(observer: Observer) {
        _observers.add(observer)
    }
}