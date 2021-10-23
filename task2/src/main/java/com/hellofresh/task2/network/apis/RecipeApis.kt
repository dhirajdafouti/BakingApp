package com.hellofresh.task2.network.apis

import androidx.lifecycle.LiveData
import com.hellofresh.task2.network.services.NetworkDataObject
import retrofit2.http.GET

/**
 * Recipe Api  communication setup via Retrofit.
 *
 */
interface RecipeApis {

    //This Api will get the Recipe Related data from the Server.
    @GET
    suspend fun getRecipe(): List<NetworkDataObject>
}