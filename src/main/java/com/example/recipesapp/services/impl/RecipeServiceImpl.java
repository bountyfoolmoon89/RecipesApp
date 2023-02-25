package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static Map<Long, Recipe> recipes = new TreeMap<>();

    public Recipe addRecipe(Recipe recipe) {
        recipes.put(id++, recipe);
        return recipe;
    }

    @Override
    public Recipe changeRecipe(Long id, Recipe recipe) {
        recipes.put(id, recipe);
        return recipe;
    }

    @Override
    public void deleteRecipe(Long id) {
        recipes.remove(id);
    }

    @Override
    public String printAllRecipes(Map<Long, Recipe> recipes) {
        return recipes.toString();
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipes.get(id);
    }

    public static long id;
}
