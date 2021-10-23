package com.hellofresh.task1.model.unselectedItems;

import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;



import java.util.List;

public interface UnSelectedItemsInterface {
    public void markSingleUnSelectedRecipe(Recipe recipe) throws MenuCardException;
    public void markMultipleUnSelectedRecipe(List<Recipe> recipeList) throws MenuCardException;

}
