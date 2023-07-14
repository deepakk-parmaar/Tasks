package com.hfad.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditFragmentViewModelFactory(private val taskId:Long,private val taskDao: TaskDao):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EditTaskViewModel::class.java)){
            return EditTaskViewModel(taskId,taskDao) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel")
    }
}