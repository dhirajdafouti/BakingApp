package com.hellofresh.task1.model.accessItems;


import com.hellofresh.task1.model.Recipe;

import java.util.List;

/**
 * This interface will be implemented by {@link AccessItemsListClass}.
 */
public interface AccessItemsInterface {

    List<Recipe> getListOfSelectedRecipes();

    List<Recipe> getListOfRecipesWithTag();

    int getListOfSelectedRecipe();

    boolean isFamilyProperty();

    List<Recipe> getAvailableListOfRecipe();

    void setListOfRecipesWithTag(List<Recipe> recipeListWithTag);

    void setListOfSelectedRecipe(List<Recipe> listOfSelectedRecipeItems);

    void setAvailableListFromMenuCard(List<Recipe> availableListFromMenuCard, boolean isFamily);
}
