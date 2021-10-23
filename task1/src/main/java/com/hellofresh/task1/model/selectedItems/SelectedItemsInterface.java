package com.hellofresh.task1.model.selectedItems;


import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.Recipe;

import java.util.List;

/**
 * This interface will be implemented by {@link SelectedRecipeItemClass}.
 */
public interface SelectedItemsInterface {

    void setSingleSelectedRecipe(Recipe recipe);

    void setMultipleSelectedRecipe(List<Recipe> recipeList) throws MenuCardException;

    void setSelectedMenuItemWithTag(String tag) throws MenuCardException;

}
