package com.hellofresh.task1.model.accessItems;


import com.hellofresh.task1.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class will provide the access for below mentioned functionalities.
 * You should be able to request a list of selected recipes and the Size.
 * You should be able to request a list of recipes which have a certain tag.
 */
public class AccessItemsListClass implements AccessItemsInterface {

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
        return selectedListOfRecipeWithTag;
    }

    @Override
    public int getListOfSelectedRecipe() {
        return selectedListOfItem.size();
    }

    @Override
    public void setListOfRecipesWithTag(List<Recipe> recipeListWithTag) {
        this.selectedListOfRecipeWithTag.clear();
        this.selectedListOfRecipeWithTag.addAll(recipeListWithTag);
    }

    @Override
    public void setListOfSelectedRecipe(List<Recipe> listOfSelectedRecipeItems) {
        selectedListOfItem.clear();
        selectedListOfItem.addAll(listOfSelectedRecipeItems);
    }


    @Override
    public void setAvailableListFromMenuCard(List<Recipe> availableListFromMenuCard, boolean isFamily) {
        this.availableListOfRecipe.clear();
        this.availableListOfRecipe.addAll(availableListFromMenuCard);
        this.isFamilyProperty = isFamily;
    }

    @Override
    public List<Recipe> getAvailableListOfRecipe() {
        return availableListOfRecipe;
    }
}
