package com.hellofresh.task1.model.selectedItems;

import com.hellofresh.task1.model.EventType;
import com.hellofresh.task1.model.Exception.MenuCardException;
import com.hellofresh.task1.model.MockAccessItemsTest;
import com.hellofresh.task1.model.Recipe;
import com.hellofresh.task1.model.Subscription;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SelectedRecipeItemClassTest extends MockAccessItemsTest {

    public SelectedRecipeItemClass selectedRecipeItemClass;
    public List<Recipe> recipeList;
    public Subscription subscription;

    @Before
    public void setUp() {
        //Testing Mock setUp.
        recipeList = new ArrayList<>();
        Recipe recipe = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipe1 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipe2 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        Recipe recipe3 = new Recipe(4, "Mango Shake Non-Veg", EventType.Cold);
        Recipe recipe4 = new Recipe(5, "Mango Shake Alma", EventType.MEDIUM_HOT);
        Recipe recipe5 = new Recipe(6, "Mango Shake Non-Alma", EventType.HOT);
        recipeList.add(recipe);
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        recipeList.add(recipe3);
        recipeList.add(recipe4);
        recipeList.add(recipe5);
        subscription = new Subscription(23, 23012012, false);
        setAvailableListFromMenuCard(recipeList, subscription.isForFamily());
        selectedRecipeItemClass = new SelectedRecipeItemClass(accessItemsInterface);
    }

    @Test
    public void testSingleSelectedItemFromTheAvailableItemList() {
        Recipe singleRecipeSelected = new Recipe(1, "Mango Shake", EventType.Cold);
        selectedRecipeItemClass.setSingleSelectedRecipe(singleRecipeSelected);
        for (Recipe recipe : accessItemsInterface.getListOfSelectedRecipes()) {
            Assert.assertEquals(singleRecipeSelected.getId(), recipe.getId());
        }

    }

    @Test
    public void testSelectThreeItemFromTheAvailableItemList() {
        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsSelectedList.add(recipeSelected1);
        threeItemsSelectedList.add(recipeSelected2);
        threeItemsSelectedList.add(recipeSelected3);
        try {
            selectedRecipeItemClass.setMultipleSelectedRecipe(threeItemsSelectedList);
            Assert.assertArrayEquals(threeItemsSelectedList.toArray(), accessItemsInterface.getListOfSelectedRecipes().toArray());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectMoreThanThreeItemWithFamilyPropertyFalseFromTheAvailableItemList() {
        accessItemsInterface.setAvailableListFromMenuCard(recipeList, false);
        List<Recipe> selectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        Recipe recipeSelected4 = new Recipe(4, "Mango Shake Non-Veg", EventType.Cold);
        selectedList.add(recipeSelected1);
        selectedList.add(recipeSelected2);
        selectedList.add(recipeSelected3);
        selectedList.add(recipeSelected4);

        try {
            selectedRecipeItemClass.setMultipleSelectedRecipe(selectedList);
            Assert.assertArrayEquals(selectedList.toArray(), accessItemsInterface.getListOfSelectedRecipes().toArray());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSelectFiveItemWithFamilyPropertyTrueFromTheAvailableItemList() {
        accessItemsInterface.setAvailableListFromMenuCard(recipeList, true);
        List<Recipe> selectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        Recipe recipeSelected4 = new Recipe(4, "Mango Shake Non-Veg", EventType.Cold);
        Recipe recipeSelected5 = new Recipe(5, "Mango Shake Alma", EventType.MEDIUM_HOT);
        selectedList.add(recipeSelected1);
        selectedList.add(recipeSelected2);
        selectedList.add(recipeSelected3);
        selectedList.add(recipeSelected4);
        selectedList.add(recipeSelected5);

        try {
            selectedRecipeItemClass.setMultipleSelectedRecipe(selectedList);
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception of Selected More Than Three With isFamily Property False", e.getCode(), 600);
        }

    }

    @Test
    public void testSelectMoreThanThreeItemWithFamilyPropertyTrueFromTheAvailableItemList() {
        Recipe singleRecipeSelected = new Recipe(1, "Mango Shake", EventType.Cold);
        selectedRecipeItemClass.setSingleSelectedRecipe(singleRecipeSelected);
        for (Recipe recipe : accessItemsInterface.getListOfSelectedRecipes()) {
            Assert.assertEquals(singleRecipeSelected.getId(), recipe.getId());
        }
    }

    @Test
    public void testSelectedItemTagTheAvailableItemList() {
        accessItemsInterface.setAvailableListFromMenuCard(recipeList,false);
        try {
            selectedRecipeItemClass.setSelectedMenuItemWithTag(EventType.Cold.getDisplayName());
            Assert.assertEquals(2,accessItemsInterface.getListOfRecipesWithTag().size());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void testSelectedWithNoItemTagTheAvailableItemList() {
        accessItemsInterface.setAvailableListFromMenuCard(recipeList,false);
        try {
            selectedRecipeItemClass.setSelectedMenuItemWithTag(EventType.NONE.getDisplayName());
            Assert.assertEquals(0,accessItemsInterface.getListOfRecipesWithTag().size());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }


    }


    @After
    public void tearDown() {
        recipeList = null;
        selectedRecipeItemClass=null;
        accessItemsInterface = null;
    }

}