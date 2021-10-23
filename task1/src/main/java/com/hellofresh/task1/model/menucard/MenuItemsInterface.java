package com.hellofresh.task1.model.menucard;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;

import java.util.List;

/**
 * This interface will be implemented by {@link MenuCard}.
 */
public interface MenuItemsInterface {
    void setListOfAvailableRecipe(List<Recipe> availableRecipeList);

    List<Recipe> getListOfAvailableRecipe() throws MenuCardException;

    List<Recipe> getListOfSelectedRecipe() throws MenuCardException;

    List<Recipe> getListOfSelectedRecipeWithTag() throws MenuCardException;

    int getNumberOfItemsSelected() throws MenuCardException;
}
