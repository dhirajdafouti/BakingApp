package com.hellofresh.task2.network.services

import com.hellofresh.task2.domainmodel.RecipeUIData
import com.squareup.moshi.Json

data class NetworkDataObject(

    @Json(name = "id") val id: String,
    @Json(name = "calories") val calories: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "difficulty") val difficulty: Int?,
    @Json(name = "fats") val fats: String?,
    @Json(name = "headline") val headline: String?,
    @Json(name = "thumb") val image: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "time") val time: String?

)

data class NetworkRecipeDataObject(val networkRecipeObject: List<NetworkDataObject>)

//Converting the network data object to domain model which is shown to the UI.
fun NetworkRecipeDataObject.asDomainObject(): List<RecipeUIData> {
    return networkRecipeObject.map {
        RecipeUIData(
            id = it.id,
            image = it.image,
            tile = it.name,
            headline = it.headline,
            date = it.time

        )
    }
}
