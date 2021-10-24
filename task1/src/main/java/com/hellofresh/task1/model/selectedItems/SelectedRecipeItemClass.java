package com.hellofresh.task1.model.selectedItems;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;
import com.hellofresh.task1.model.accessItems.AccessItemsInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will provide the mentioned functionalities.
 * <p>
 * You should be able to select a single selected recipe.
 * You should be able to select multiple selected recipes.
 * You should be able to select recipes with the tag.
 * Note:
 * Restricting the behavior
 * <p>
 * You should not be able to select more than 3 recipes.
 * <p>
 * Modifying the behavior based on subscription type
 * <p>
 * You should be able to select up to 5 recipes if the subscription is for a family.
 */
class SelectedRecipeItemClass implements SelectedItemsInterface {

    private final List<Recipe> selectedRecipeFromAvailableList = new ArrayList<>();

    private final List<Recipe> selectedRecipeListWithTag = new ArrayList<>();

    private final AccessItemsInterface accessItemsInterface;

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
        if (accessItemsInterface.isFamilyProperty()) {
            if (recipeList.size() <= 5) {
                createListOfMultipleSelectedItems(recipeList);
            }
        } else if (recipeList.size() <= 3) {
            createListOfMultipleSelectedItems(recipeList);
        } else {
            accessItemsInterface.setListOfSelectedRecipe(selectedRecipeFromAvailableList);
            throw new MenuCardException("Selection for More Recipe Items are not allowed!!", 600);
        }
        accessItemsInterface.setListOfSelectedRecipe(selectedRecipeFromAvailableList);
    }

    /**
     * This method will create a list of selected recipe items.
     *
     * @param recipeList :selected items recipe.
     */
    private void createListOfMultipleSelectedItems(List<Recipe> recipeList) {
        for (Recipe available : accessItemsInterface.getAvailableListOfRecipe()) {
            for (Recipe selected : recipeList) {
                if (available.getId() == selected.getId()) {
                    selectedRecipeFromAvailableList.add(selected);
                }
            }
        }
    }

    @Override
    public void setSelectedMenuItemWithTag(String tag) throws MenuCardException {
        selectedRecipeListWithTag.clear();
        for (Recipe value : accessItemsInterface.getAvailableListOfRecipe()) {
            if (tag.equalsIgnoreCase(value.getEvent().getDisplayName())) {
                selectedRecipeListWithTag.add(value);
            }
        }
        //set the list of items selected as Tag empty.
        accessItemsInterface.setListOfRecipesWithTag(selectedRecipeListWithTag);

        if (selectedRecipeListWithTag.size() == 0) {
            throw new MenuCardException("No Recipe Item With Tag Selected", 900);
        }

    }

}
