package com.lamarck.mymvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lamarck.mymvvm.repositories.MainRepository
import com.lamarck.mymvvm.viewmodel.main.MainViewModel

class MainViewModelFactory constructor(private val repository: MainRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}