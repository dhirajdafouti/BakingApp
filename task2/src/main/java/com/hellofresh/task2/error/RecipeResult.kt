package com.hellofresh.task2.error

import com.hellofresh.task2.domainmodel.RecipeUIData

/**
 * This class will holds the success and failure results from the Server.
 */
sealed class RecipeResult {
    data class Success(val data: List<RecipeUIData>) : RecipeResult()
    data class Error(val error: String) : RecipeResult()
}

