package com.hellofresh.task1.model;


import static junit.framework.TestCase.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeTest {

    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void testRecipeIdValue() {
        recipe.setId(1234);
        assertEquals(1234, recipe.getId());
    }

    @Test
    public void testRecipeTitleValue() {
        recipe.setTitle("Mango Shake");
        assertEquals("Mango Shake", recipe.getTitle());
    }

    @Test
    public void testRecipeEventTypeValue() {
        recipe.setEvent(EventType.HOT);
        assertEquals("Hot", recipe.getEvent().getDisplayName());
        recipe.setEvent(EventType.MEDIUM_HOT);
        assertEquals("MediumHot", recipe.getEvent().getDisplayName());
        recipe.setEvent(EventType.Cold);
        assertEquals("Cold", recipe.getEvent().getDisplayName());
        recipe.setEvent(EventType.NONE);
        assertEquals("None", recipe.getEvent().getDisplayName());
    }

    @After
    public void tearDown() {
        recipe = null;
    }
}