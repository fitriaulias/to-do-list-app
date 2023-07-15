package com.dicoding.todoapp.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.data.TaskRepository
import kotlinx.coroutines.launch

class AddTaskViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    private val _task = MutableLiveData<Task>()
    val task: LiveData<Task> = _task

    fun insertNewTask(title: String, description: String, dueDateMillis: Long) {
        viewModelScope.launch {
        val task = Task(
            title = title, description = description, dueDateMillis = dueDateMillis)
            taskRepository.insertTask(task) }
    }
}