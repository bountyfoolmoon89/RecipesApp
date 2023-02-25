package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {

    Ingredient getIngredient(Long numberOfIngredient);

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient changeIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient ingredient);

    String printAllIngredients(Map<Long, Ingredient> ingredients);
}
