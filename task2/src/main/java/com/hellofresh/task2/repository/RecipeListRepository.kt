package com.hellofresh.task2.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hellofresh.task2.Error.RecipeResult
import com.hellofresh.task2.domainmodel.RecipeUIData
import com.hellofresh.task2.network.services.NetworkRecipeDataObject
import com.hellofresh.task2.network.services.RecipeService
import com.hellofresh.task2.network.services.asDomainObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

class RecipeListRepository(private val application: Application) {

    val recipeResult = MutableLiveData<RecipeResult>()

    private var _progressBar: MutableLiveData<Boolean> = MutableLiveData(false)
    val progressBar: LiveData<Boolean> get() = _progressBar

    private var successful = false

    //The Suspend method will request for Recipe data to the Network.

    suspend fun getRecipeDataFromNetwork() {
        Timber.d("Recipe Data Request is send to Server")
        _progressBar.value = true
        withContext(Dispatchers.IO) {
            requestRecipeDataFromNetwork()
        }
        _progressBar.value = false
    }

    private suspend fun requestRecipeDataFromNetwork(): Boolean {
        var listOfRecipeResponse: List<RecipeUIData> = emptyList()
        try {
            listOfRecipeResponse =
                NetworkRecipeDataObject(RecipeService.recipeService.getRecipe()).asDomainObject()
            recipeResult.postValue(RecipeResult.Success(listOfRecipeResponse))
            successful = true
        } catch (exception: IOException) {
            Timber.d("The IO exception Received!!! $exception")
            recipeResult.postValue(RecipeResult.Error(exception))
            successful = false
        } catch (exception: HttpException) {
            Timber.d("The Http exception Received!!! $exception")
            recipeResult.postValue(RecipeResult.Error(exception))
            successful = false
        }
        return successful
    }


    suspend fun performRetryOnRepository() {
        Timber.d("The Retry Operation is performed:{}!!!")
        if (successful) return
        getRecipeDataFromNetwork()
    }


}