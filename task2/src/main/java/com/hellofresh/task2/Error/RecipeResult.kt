package com.hellofresh.task2.Error

import com.hellofresh.task2.domainmodel.RecipeUIData

sealed class RecipeResult {
    data class Success(val data: List<RecipeUIData>) : RecipeResult()
    data class Error(val error: Exception) : RecipeResult()
}

