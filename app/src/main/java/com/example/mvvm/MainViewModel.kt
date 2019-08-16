package com.example.mvvm

import androidx.lifecycle.LiveData
import com.example.mvvm.model.Task

class MainViewModel {

    //    private val task = MutableLiveData<Task>().apply {
//
//    }
    private var task = Task(
        id = "123",
        title = "Android Live Streaming",
        content = "MVVM Basic"
    )
    val title: LiveData<String>
    var titleText = task.title
    var contextText = task.content
    var buttonText = task.
}