package com.example.recipesapp.services.impl;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {

    final private RecipesFilesServiceImpl recipesFilesService;

    private static Map<Long, Recipe> recipes = new TreeMap<>();

    public RecipeServiceImpl(RecipesFilesServiceImpl filesService) {
        this.recipesFilesService = filesService;
    }

    public void addRecipe(Recipe recipe) {
        recipes.put(id++, recipe);
        saveToFile();
    }

    @Override
    public void changeRecipe(Long id, Recipe recipe) {
        recipes.put(id, recipe);
        saveToFile();
    }

    @Override
    public void deleteRecipe(Long id) {
        if (!recipes.containsKey(id)) {
            throw new IllegalArgumentException("Ингредиент под номером " + id + " не найден");
        }
        recipes.remove(id);
    }

    @Override
    public String printAllRecipes(Map<Long, Recipe> recipes) {
        return recipes.toString();
    }

    @Override
    public Recipe getRecipe(Long id) {
        if (!recipes.containsKey(id)) {
            throw new IllegalArgumentException("Ингредиент под номером " + id + " не найден");
        }
        return recipes.get(id);
    }

    public static long id;

    @Override
    public void init(){
        readFromFile();
    }

    @Override
    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            recipesFilesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void readFromFile() {
        try {
            String json = recipesFilesService.readFromFile();
            recipes = new ObjectMapper().readValue(json, new TypeReference<Map<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
