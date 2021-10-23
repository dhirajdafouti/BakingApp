package com.hellofresh.task1.model.menucard;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;

import java.util.List;

public interface MenuItemsInterface {
    public void setListOfAvailableRecipe(List<Recipe> availableRecipeList);
    public List<Recipe> getListOfAvailableRecipe() throws MenuCardException;
    public List<Recipe>getListOfSelectedRecipe() throws MenuCardException;
    public List<Recipe>getListOfSelectedRecipeWithTag() throws MenuCardException;
    public int getNumberOfItemsSelected() throws MenuCardException;
}
