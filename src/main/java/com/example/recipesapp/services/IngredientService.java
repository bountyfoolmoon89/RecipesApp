package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {

    Ingredient getIngredient(Long id);

    Ingredient addIngredient(Ingredient ingredient);

    Ingredient changeIngredient(Long id, Ingredient ingredient);

    void deleteIngredient(Long id);

    String printAllIngredients(Map<Long, Ingredient> ingredients);
}
