package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {

    final private RecipesFilesServiceImpl recipesFilesService;
    private static Map<Long, Ingredient> ingredients = new HashMap<>();

    public IngredientServiceImpl(RecipesFilesServiceImpl filesService) {
        this.recipesFilesService = filesService;
    }

    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id++, ingredient);
        saveToFile();
        return ingredient;
    }

    @Override
    public Ingredient changeIngredient(Long id, Ingredient ingredient) {
        ingredients.put(id, ingredient);
        saveToFile();
        return null;
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
    public Ingredient getIngredient(Long id) {
        return ingredients.get(id);
    }

    public static long id;

    @PostConstruct
    private void init() {
        readFromFile();
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            recipesFilesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = recipesFilesService.readFromFile();
            ingredients = new ObjectMapper().readValue(json, new TypeReference<Map<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
