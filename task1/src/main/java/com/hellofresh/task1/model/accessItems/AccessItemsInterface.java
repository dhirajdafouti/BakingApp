package com.hellofresh.task1.model.accessItems;


import com.hellofresh.task1.model.Recipe;

import java.util.List;

public interface AccessItemsInterface {

    public List<Recipe> getListOfSelectedRecipes();

    public List<Recipe> getListOfRecipesWithTag();

    public int getListOfSelectedRecipe();

    public boolean isFamilyProperty();

    public List<Recipe> getAvailableListOfRecipe();

    public void setListOfRecipesWithTag(List<Recipe> recipeListWithTag);

    public void setListOfSelectedRecipe(List<Recipe> listOfSelectedRecipeItems);

    public void setAvailableListFromMenuCard(List<Recipe> availableListFromMenuCard, boolean isFamily);
}
