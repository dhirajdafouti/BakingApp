package com.hellofresh.task1.model.selectedItems;



import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;

import java.util.List;

public interface SelectedItemsInterface {

    public void setSingleSelectedRecipe(Recipe recipe) ;
    public void setMultipleSelectedRecipe(List<Recipe> recipeList) throws MenuCardException;

}
