package com.wehightech.whattoeat.rest;

import com.wehightech.whattoeat.domain.Recipe;
import com.wehightech.whattoeat.repository.RecipeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping(path = "/api/recipes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Recipe> getAllRecipses() {
        return recipeRepository.getAllRecipes();
    }
}
