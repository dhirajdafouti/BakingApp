package com.hellofresh.task1.model.unselectedItems;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;
import com.hellofresh.task1.model.accessItems.AccessItemsInterface;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class will provide the mentioned functionalities for unselecting the recipe items.
 * <p>
 * You should be able to unselect a single selected recipe.
 * You should be able to unselect multiple selected recipes.
 */
public class UnSelectedRecipeItemClass implements UnSelectedItemsInterface {


    private final AccessItemsInterface accessItemsInterface;

    public UnSelectedRecipeItemClass(AccessItemsInterface accessRecipeInterface) {
        this.accessItemsInterface = accessRecipeInterface;
    }

    @Override
    public void markSingleUnSelectedRecipe(Recipe recipe) throws MenuCardException {
        if (accessItemsInterface.getListOfSelectedRecipes().size() > 0) {
            accessItemsInterface.getListOfSelectedRecipes().removeIf(value -> recipe.getId() == value.getId());
        } else {
            throw new MenuCardException("No Recipe Items to UnSelect", 800);
        }

    }

    @Override
    public void markMultipleUnSelectedRecipe(List<Recipe> recipeList) throws MenuCardException {
        CopyOnWriteArrayList<Recipe> selectedList = new CopyOnWriteArrayList<>(accessItemsInterface.getListOfSelectedRecipes());
        if (accessItemsInterface.getListOfSelectedRecipes().size() > 0) {
            for (Recipe value : selectedList) {
                for (Recipe recipe : recipeList) {
                    if (value.getId() == recipe.getId()) {
                        selectedList.remove(value);
                    }
                }
            }
        } else {
            accessItemsInterface.setListOfSelectedRecipe(selectedList);
            throw new MenuCardException("No Recipe Items to UnSelect", 900);
        }
        accessItemsInterface.setListOfSelectedRecipe(selectedList);
    }


}
