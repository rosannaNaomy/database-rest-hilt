package com.example.databasemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.databasemvvm.model.RepositoryData
import com.example.databasemvvm.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository: RetroRepository): ViewModel() {

    fun getAllRepositoryList(): LiveData<List<RepositoryData>>{
        return repository.getAllRecords()
    }

    fun makeAPICall(){
        repository.makeAPICall("ny")
    }
}