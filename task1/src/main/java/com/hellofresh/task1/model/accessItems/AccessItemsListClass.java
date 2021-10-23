package com.hellofresh.task1.model.accessItems;


import com.hellofresh.task1.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AccessItemsListClass implements AccessItemsInterface {
    @Override
    public List<Recipe> getAvailableListOfRecipe() {
        return availableListOfRecipe;
    }

    private final List<Recipe> availableListOfRecipe = new ArrayList<>();
    private boolean isFamilyProperty;

    private final CopyOnWriteArrayList<Recipe> selectedListOfItem = new CopyOnWriteArrayList<>();

    private final List<Recipe> selectedListOfRecipeWithTag = new ArrayList<>();

    @Override
    public boolean isFamilyProperty() {
        return isFamilyProperty;
    }

    @Override
    public List<Recipe> getListOfSelectedRecipes() {
        return selectedListOfItem;
    }

    @Override
    public List<Recipe> getListOfRecipesWithTag() {
        return null;
    }

    @Override
    public int getListOfSelectedRecipe() {
        return selectedListOfItem.size();
    }

    @Override
    public void setListOfRecipesWithTag(List<Recipe> recipeListWithTag) {
        this.selectedListOfRecipeWithTag.addAll(recipeListWithTag);
    }

    @Override
    public void setListOfSelectedRecipe(List<Recipe> listOfSelectedRecipeItems) {
        selectedListOfItem.clear();
        selectedListOfItem.addAll(listOfSelectedRecipeItems);
    }


    public List<Recipe> getSelectedListOfRecipeWithTag() {
        return selectedListOfRecipeWithTag;
    }

    @Override
    public void setAvailableListFromMenuCard(List<Recipe> availableListFromMenuCard, boolean isFamily) {
        this.availableListOfRecipe.clear();
        this.availableListOfRecipe.addAll(availableListFromMenuCard);
        this.isFamilyProperty = isFamily;
    }
}
