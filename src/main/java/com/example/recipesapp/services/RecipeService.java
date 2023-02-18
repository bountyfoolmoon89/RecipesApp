package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;

public interface RecipeService {

    Recipe getRecipe(Long numberOfRecipe);

    Recipe addRecipe(Recipe recipe);
}
