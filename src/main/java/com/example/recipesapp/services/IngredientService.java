package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;

public interface IngredientService {

    Ingredient getIngredient(Long numberOfIngredient);

    Ingredient addIngredient(Ingredient ingredient);

}
