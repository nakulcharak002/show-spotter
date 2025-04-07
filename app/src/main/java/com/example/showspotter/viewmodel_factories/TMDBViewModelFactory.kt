package com.example.showspotter.viewmodel_factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.showspotter.repositories.TMDBRepository
import com.example.showspotter.viewmodels.TMDBViewModel

class TMDBViewModalFactory(private val TMDBRepository: TMDBRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TMDBViewModel::class.java)) {
            return TMDBViewModel(TMDBRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
