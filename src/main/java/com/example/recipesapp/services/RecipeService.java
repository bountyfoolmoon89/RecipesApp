package com.example.recipesapp.services;

import com.example.recipesapp.model.Recipe;

import java.util.Map;

public interface RecipeService {

    Recipe getRecipe(Long id);

    void addRecipe(Recipe recipe);

    void changeRecipe(Long id, Recipe recipe);

    void deleteRecipe(Long id);

    String printAllRecipes(Map<Long, Recipe> recipes);

    void init();

    void saveToFile();

    void readFromFile();
}
