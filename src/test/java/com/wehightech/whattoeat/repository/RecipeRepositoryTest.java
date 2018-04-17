package com.wehightech.whattoeat.repository;

import com.wehightech.whattoeat.domain.Ingredient;
import com.wehightech.whattoeat.domain.Recipe;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RecipeRepositoryTest {

    private static final int ID_RECIPE_TEST = 99;
    private static final int EXPECTED_ID_RECIPE_TEST = 99;
    private RecipeRepository recipeRepository;

    @Before
    public void setUp() {
        recipeRepository = new RecipeRepository();
    }

    @After
    public void tearDown() {
        recipeRepository = null;
    }

    @Test
    public void getAllRecipes() {
        Assertions.assertThat(recipeRepository.getAllRecipes()).isNotEmpty();
    }

    @Test
    public void addRecipe() {
        Recipe anyRecipe = new Recipe(ID_RECIPE_TEST, "Any Recipe", "Anything eatable", Arrays.asList(new Ingredient("ingredient1"),
            new Ingredient("ingredient2")));
        Assertions.assertThat(recipeRepository.addRecipe(anyRecipe)).isEqualTo(EXPECTED_ID_RECIPE_TEST);
    }

    @Test
    public void findRecipeById() {
        // Given
        Recipe anyRecipe = new Recipe(ID_RECIPE_TEST, "Any Recipe", "Anything eatable", Arrays.asList(new Ingredient("ingredient1"),
            new Ingredient("ingredient2")));
        // When
        recipeRepository.addRecipe(anyRecipe);
        // Then
        Assertions.assertThat(recipeRepository.findRecipeById(anyRecipe.getId()).get()).isEqualTo(anyRecipe);

    }

    @Test
    public void removeRecipe() {
        // Given
        Recipe anyRecipe = new Recipe(ID_RECIPE_TEST, "Any Recipe", "Anything eatable", Arrays.asList(new Ingredient("ingredient1"),
            new Ingredient("ingredient2")));
        // When
        recipeRepository.addRecipe(anyRecipe);
        recipeRepository.removeRecipe(anyRecipe);
        // Then
        Assertions.assertThat(recipeRepository.findRecipeById(anyRecipe.getId())).isEmpty();
    }
}
