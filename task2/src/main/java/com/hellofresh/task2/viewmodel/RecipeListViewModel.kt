package com.hellofresh.task2.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellofresh.task2.error.RecipeResult
import com.hellofresh.task2.repository.RecipeListRepository
import kotlinx.coroutines.launch

class RecipeListViewModel(private val application: Application) : ViewModel() {

    private val repository = RecipeListRepository(application)

    //live data variable for recipe data from server.
    val repoResult: LiveData<RecipeResult>
        get() =
            repository.recipeResult

    //live data variable for progress bar.
    val progressBar: LiveData<Boolean>
        get() = repository.progressBar

    //this function will request the data from the server.
    fun triggerRecipeRequestToService() {
        viewModelScope.launch {
            repository.getRecipeDataFromNetwork()
        }
    }

    //this function will again trigger the request if it fails for the first time.
    fun retryRecipeRequestToService() {
        viewModelScope.launch {
            repository.performRetryOnRepository()
        }
    }
}