package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    public Recipe getRecipes(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    public void addRecipes(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @PutMapping("/{id}")
    public void changeRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipeService.changeRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping
    public void printRecipes(@RequestBody Map<Long, Recipe> recipes) {
        recipeService.printAllRecipes(recipes);
    }
}
