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

    final private FilesServiceImpl filesService;

    private static Map<Long, Recipe> recipes = new TreeMap<>();

    public RecipeServiceImpl(FilesServiceImpl filesService) {
        this.filesService = filesService;
    }

    public Recipe addRecipe(Recipe recipe) {
        recipes.put(id++, recipe);
        saveToFile();
        return recipe;
    }

    @Override
    public Recipe changeRecipe(Long id, Recipe recipe) {
        recipes.put(id, recipe);
        saveToFile();
        return null;
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

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        try {
            String json = filesService.readFromFile();
            recipes = new ObjectMapper().readValue(json, new TypeReference<Map<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
