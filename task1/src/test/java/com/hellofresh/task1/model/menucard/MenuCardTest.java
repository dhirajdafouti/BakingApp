package com.hellofresh.task1.model.menucard;

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

public class MenuCardTest extends MockAccessItemsTest {
    private MenuCard menuCard;
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
        menuCard = new MenuCard(accessItemsInterface, subscription);
        menuCard.setListOfAvailableRecipe(recipeList);
    }

    @Test
    public void testAvailableRecipeItemList() {
        try {
            Assert.assertArrayEquals(recipeList.toArray(), menuCard.getListOfAvailableRecipe().toArray());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testNoAvailableRecipeItemList() {
        menuCard.setListOfAvailableRecipe(new ArrayList<>());
        try {
            menuCard.getListOfAvailableRecipe();
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception No available Items.", e.getCode(), 100);
        }
    }
    @Test
    public void testSelectedItemsFromTheAvailableRecipeList() {
        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsSelectedList.add(recipeSelected1);
        threeItemsSelectedList.add(recipeSelected2);
        threeItemsSelectedList.add(recipeSelected3);
        accessItemsInterface.setListOfSelectedRecipe(threeItemsSelectedList);
        try {
            Assert.assertArrayEquals(threeItemsSelectedList.toArray(),menuCard.getListOfSelectedRecipe().toArray());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectedItemsSizeFromTheAvailableRecipeList() {
        List<Recipe> threeItemsSelectedList = new ArrayList<>();
        Recipe recipeSelected1 = new Recipe(1, "Mango Shake", EventType.Cold);
        Recipe recipeSelected2 = new Recipe(2, "Mango Shake fruit", EventType.HOT);
        Recipe recipeSelected3 = new Recipe(3, "Mango Shake Veg", EventType.HOT);
        threeItemsSelectedList.add(recipeSelected1);
        threeItemsSelectedList.add(recipeSelected2);
        threeItemsSelectedList.add(recipeSelected3);
        accessItemsInterface.setListOfSelectedRecipe(threeItemsSelectedList);
        try {
            Assert.assertEquals(3, menuCard.getNumberOfItemsSelected());
        } catch (MenuCardException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSelectedZeroSizeFromTheAvailableRecipeList() {
        List<Recipe> noItemSelected = new ArrayList<>();
        accessItemsInterface.setListOfSelectedRecipe(noItemSelected);
        try {
             menuCard.getNumberOfItemsSelected();
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception No Item is Previously Selected.", e.getCode(), 500);
        }

    }

    @Test
    public void testNoSelectedItemsFromTheAvailableRecipeList() {
        accessItemsInterface.setListOfSelectedRecipe(new ArrayList<>());
        try {
            menuCard.getListOfSelectedRecipe();
        } catch (MenuCardException e) {
            Assert.assertEquals("Menu Card Exception No Item is Previously Selected.", e.getCode(), 200);
        }

    }

    @After
    public void tearDown() {
        accessItemsInterface = null;
        menuCard = null;
        recipeList = null;
    }
}