package com.example.recipesapp.services;

import com.example.recipesapp.model.Ingredient;

import java.util.Map;

public interface IngredientService {

    Ingredient getIngredient(Long id);

    void addIngredient(Ingredient ingredient);

    void changeIngredient(Long id, Ingredient ingredient);

    void deleteIngredient(Long id);

    String printAllIngredients(Map<Long, Ingredient> ingredients);

    void init();

    void saveToFile();

    void readFromFile();
}
