package com.wehightech.whattoeat.domain;

import java.util.List;

public class Recipe {
    private Integer id;
    private String name;
    private String description;
    private List<Ingredient> ingredients;

    public Recipe(Integer id, String name, String description, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
