package com.hellofresh.task1.model.unselectedItems;

import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;

import java.util.List;

/**
 * This interface will be implemented by {@link UnSelectedRecipeItemClass}.
 */
public interface UnSelectedItemsInterface {
    void markSingleUnSelectedRecipe(Recipe recipe) throws MenuCardException;

    void markMultipleUnSelectedRecipe(List<Recipe> recipeList) throws MenuCardException;

}
