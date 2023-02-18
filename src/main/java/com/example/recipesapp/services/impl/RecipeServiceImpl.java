package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {

    private static Map<Long, Recipe> recipes = new TreeMap<>();

    public Recipe addRecipe(Recipe recipe) {
        recipes.put(numberOfRecipe++, recipe);
        return recipe;
    }

    @Override
    public Recipe getRecipe(Long numberOfRecipe) {
        return recipes.get(numberOfRecipe);
    }

    public static long numberOfRecipe;


}
