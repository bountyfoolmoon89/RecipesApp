package com.example.recipesapp.services;

import com.example.recipesapp.model.Recipe;

import java.util.Map;

public interface RecipeService {

    Recipe getRecipe(Long id);

    Recipe addRecipe(Recipe recipe);

    Recipe changeRecipe(Long id, Recipe recipe);

    void deleteRecipe(Long id);

    String printAllRecipes(Map<Long, Recipe> recipes);
}
