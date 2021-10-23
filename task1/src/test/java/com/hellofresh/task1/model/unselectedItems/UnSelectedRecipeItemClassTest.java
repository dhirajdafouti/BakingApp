package com.hellofresh.task1.model.unselectedItems;

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

public class UnSelectedRecipeItemClassTest extends MockAccessItemsTest {
    public UnSelectedRecipeItemClass unSelectedRecipeItemClass;
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
        unSelectedRecipeItemClass = new UnSelectedRecipeItemClass(accessItemsInterface);
    }

    @Test
    public void testSingleUnSelectedItemFromTheAvailableItemList() {
        Recipe singleUnSelectedItem = new Recipe(1, "Mango Shake", EventType.Cold);
        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsSelectedList.add(recipeSelected1);
        threeItemsSelectedList.add(recipeSelected2);
        threeItemsSelectedList.add(recipeSelected3);
        accessItemsInterface.setListOfSelectedRecipe(threeItemsSelectedList);
        try {
            unSelectedRecipeItemClass.markSingleUnSelectedRecipe(singleUnSelectedItem);
            Assert.assertEquals(2, accessItemsInterface.getListOfSelectedRecipe());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testNoSingleUnSelectedItemFromTheAvailableItemList() {
        Recipe singleUnSelectedItem = new Recipe(1, "Mango Shake", EventType.Cold);
        List<Recipe> noItemSelected = new ArrayList<>();
        accessItemsInterface.setListOfSelectedRecipe(noItemSelected);
        try {
            unSelectedRecipeItemClass.markSingleUnSelectedRecipe(singleUnSelectedItem);
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception No Item is Previously Selected.", e.getCode(), 800);
        }

    }

    @Test
    public void testMultipleUnSelectedItemFromTheAvailableItemList() {

        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsSelectedList.add(recipeSelected1);
        threeItemsSelectedList.add(recipeSelected2);
        threeItemsSelectedList.add(recipeSelected3);

        List<Recipe> threeItemsUnSelectedList = new ArrayList<>();
        Recipe singleUnSelectedItem1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe singleUnSelectedItem2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe singleUnSelectedItem3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsUnSelectedList.add(singleUnSelectedItem1);
        threeItemsUnSelectedList.add(singleUnSelectedItem2);
        threeItemsUnSelectedList.add(singleUnSelectedItem3);

        accessItemsInterface.setListOfSelectedRecipe(threeItemsSelectedList);
        try {
            unSelectedRecipeItemClass.markMultipleUnSelectedRecipe(threeItemsUnSelectedList);
            Assert.assertEquals(0, accessItemsInterface.getListOfSelectedRecipe());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testNoMultipleUnSelectedItemFromTheAvailableItemList() {

        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        List<Recipe> threeItemsUnSelectedList = new ArrayList<>();
        Recipe singleUnSelectedItem1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe singleUnSelectedItem2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe singleUnSelectedItem3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsUnSelectedList.add(singleUnSelectedItem1);
        threeItemsUnSelectedList.add(singleUnSelectedItem2);
        threeItemsUnSelectedList.add(singleUnSelectedItem3);
        accessItemsInterface.setListOfSelectedRecipe(threeItemsSelectedList);
        try {
            unSelectedRecipeItemClass.markMultipleUnSelectedRecipe(threeItemsUnSelectedList);
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception No Item is Previously Selected.", e.getCode(), 900);
        }

    }


    @After
    public void tearDown() {
        recipeList = null;
        unSelectedRecipeItemClass = null;
        accessItemsInterface = null;
    }
}