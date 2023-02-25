package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {


    private static Map<Long, Ingredient> ingredients = new HashMap<>();

    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id++, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient changeIngredient(Long id, Ingredient ingredient) {
        return ingredients.put(id, ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredients.remove(id);
    }

    @Override
    public String printAllIngredients(Map<Long, Ingredient> ingredients) {
        return ingredients.toString();
    }

    @Override
    public Ingredient getIngredient(Long numberOfIngredient) {
        return ingredients.get(numberOfIngredient);
    }

    public static long id;
}
