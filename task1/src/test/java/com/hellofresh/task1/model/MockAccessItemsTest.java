package com.hellofresh.task1.model;

import com.hellofresh.task1.model.accessItems.AccessItemsInterface;
import com.hellofresh.task1.model.accessItems.AccessItemsListClass;

import java.util.List;

public class MockAccessItemsTest implements AccessItemsInterface {


    protected AccessItemsInterface accessItemsInterface;

    public MockAccessItemsTest() {
        accessItemsInterface = new AccessItemsListClass();
    }

    @Override
    public List<Recipe> getListOfSelectedRecipes() {
        return null;
    }

    @Override
    public List<Recipe> getListOfRecipesWithTag() {
        return null;
    }

    @Override
    public int getListOfSelectedRecipe() {
        return 0;
    }

    @Override
    public boolean isFamilyProperty() {
        return false;
    }

    @Override
    public List<Recipe> getAvailableListOfRecipe() {
        return null;
    }

    @Override
    public void setListOfRecipesWithTag(List<Recipe> recipeListWithTag) {
        accessItemsInterface.setListOfRecipesWithTag(recipeListWithTag);
    }

    @Override
    public void setListOfSelectedRecipe(List<Recipe> listOfSelectedRecipeItems) {
        accessItemsInterface.setListOfSelectedRecipe(listOfSelectedRecipeItems);
    }

    @Override
    public void setAvailableListFromMenuCard(List<Recipe> availableListFromMenuCard, boolean isFamily) {
        accessItemsInterface.setAvailableListFromMenuCard(availableListFromMenuCard, isFamily);
    }

}
