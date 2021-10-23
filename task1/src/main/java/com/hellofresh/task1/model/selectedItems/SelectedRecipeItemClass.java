package com.hellofresh.task1.model.selectedItems;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;
import com.hellofresh.task1.model.accessItems.AccessItemsInterface;

import java.util.ArrayList;
import java.util.List;

class SelectedRecipeItemClass implements SelectedItemsInterface {


    private List<Recipe> selectedRecipeFromAvailableList = new ArrayList<>();

    private AccessItemsInterface accessItemsInterface;

    public SelectedRecipeItemClass(AccessItemsInterface accessRecipeInterface) {
        this.accessItemsInterface = accessRecipeInterface;
    }

    @Override
    public void setSingleSelectedRecipe(Recipe recipe) {
        selectedRecipeFromAvailableList.clear();
        for (Recipe value : accessItemsInterface.getAvailableListOfRecipe()) {
            if (recipe.getId() == value.getId()) {
                selectedRecipeFromAvailableList.add(value);
            }
        }
        accessItemsInterface.setListOfSelectedRecipe(selectedRecipeFromAvailableList);
    }

    @Override
    public void setMultipleSelectedRecipe(List<Recipe> recipeList) throws MenuCardException {
        if (accessItemsInterface.isFamilyProperty() && recipeList.size() <= 5) {
            for (Recipe available : accessItemsInterface.getAvailableListOfRecipe()) {
                for (Recipe selected : recipeList) {
                    if (available.getId() == selected.getId()) {
                        selectedRecipeFromAvailableList.add(selected);
                    }
                }
            }
        } else if (!accessItemsInterface.isFamilyProperty() && recipeList.size() <= 3) {
            for (Recipe available : accessItemsInterface.getAvailableListOfRecipe()) {
                for (Recipe selected : recipeList) {
                    if (available.getId() == selected.getId()) {
                        selectedRecipeFromAvailableList.add(selected);
                    }
                }
            }

        } else {
            throw new MenuCardException("Selection More Than 3 are not allowed!!", 600);
        }
        accessItemsInterface.setListOfSelectedRecipe(selectedRecipeFromAvailableList);
    }

}
