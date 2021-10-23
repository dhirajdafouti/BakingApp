package com.hellofresh.task1.model.menucard;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;
import com.hellofresh.task1.model.Subscription;
import com.hellofresh.task1.model.accessItems.AccessItemsInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will provide the below mentioned functionalities .
 * <p>
 * <p>
 * A list of recipes available for selection is provided to the menu.
 * Menu exposes a list of recipes available for selection.
 * Menu will also expose the number of recipe items are selected.
 * Menu will also expose the number of recipe items are selected with Tag too.
 */

public class MenuCard implements MenuItemsInterface {

    private final AccessItemsInterface accessItemsInterface;

    private final Subscription subscription;

    protected List<Recipe> availableRecipeList = new ArrayList<>();

    public MenuCard(AccessItemsInterface accessItemsListClass,
                    Subscription subscription) {
        this.accessItemsInterface = accessItemsListClass;
        this.subscription = subscription;
    }

    @Override
    public void setListOfAvailableRecipe(List<Recipe> availableRecipeList) {
        this.availableRecipeList.clear();
        this.availableRecipeList.addAll(availableRecipeList);
        this.accessItemsInterface.setAvailableListFromMenuCard(availableRecipeList, subscription.isForFamily());
    }

    @Override
    public List<Recipe> getListOfAvailableRecipe() throws MenuCardException {
        if (availableRecipeList != null && availableRecipeList.size() > 0) {
            return availableRecipeList;
        } else {
            throw new MenuCardException("No Recipe List Are Available.", 100);
        }

    }

    @Override
    public List<Recipe> getListOfSelectedRecipe() throws MenuCardException {
        if (accessItemsInterface != null && accessItemsInterface.getListOfSelectedRecipes().size() > 0) {
            return accessItemsInterface.getListOfSelectedRecipes();
        } else {
            throw new MenuCardException("No Selected Recipe List Are Available.", 200);
        }
    }

    @Override
    public List<Recipe> getListOfSelectedRecipeWithTag() throws MenuCardException {
        if (accessItemsInterface != null) {
            return accessItemsInterface.getListOfRecipesWithTag();
        } else {
            throw new MenuCardException("No Selected Recipe List With Tag Are Available.", 300);
        }
    }


    @Override
    public int getNumberOfItemsSelected() throws MenuCardException {
        if (accessItemsInterface != null && accessItemsInterface.getListOfSelectedRecipes().size() > 0) {
            return accessItemsInterface.getListOfSelectedRecipe();
        } else {
            throw new MenuCardException("Zero Item Recipe List are Selected.", 500);
        }
    }
}
