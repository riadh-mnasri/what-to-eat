package com.wehightech.whattoeat.repository;

import com.wehightech.whattoeat.domain.Ingredient;
import com.wehightech.whattoeat.domain.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RecipeRepository {

    private static final List<Recipe> RECIPES = Arrays.asList(
        new Recipe(1, "Coucous", "Couscous royal", Arrays.asList(new Ingredient("Semoule"),
            new Ingredient("Poulet"))),
        new Recipe(2, "Pâtes", "Pâtes", Arrays.asList(new Ingredient("Pâtes"),
            new Ingredient("Poulet"), new Ingredient("Poisson"))),
        new Recipe(3, "Poisson grillé", "Poisson grillé", Arrays.asList(new Ingredient("Poisson"),
            new Ingredient("Salade")))
    );

    private List<Recipe> recipes = new ArrayList<>(RECIPES);

    public List<Recipe> getAllRecipes(){
        return recipes;
    }

    public Integer addRecipe(Recipe recipe){
        if(!recipes.stream().anyMatch(r -> r.getId().equals(recipe.getId()))){
         recipes.add(recipe);
        }
        return recipe.getId();
    }

    public void removeRecipe(Recipe recipe){
        if(recipes.stream().anyMatch(r -> r.getId().equals(recipe.getId()))){
            recipes.remove(recipe);
        }
    }

}
