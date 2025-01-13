package com.example.showspotter.tmdbMVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModalFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(com.example.showspotter.tmdbMVVM.ViewModel::class.java)) {
            return ViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
