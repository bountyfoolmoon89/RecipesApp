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

    @GetMapping("/getRecipe")
    public Long getRecipes(@RequestParam Long numberOfRecipe) {
        recipeService.getRecipe(numberOfRecipe);
        return numberOfRecipe;
    }

    @PostMapping("/addRecipes")
    public void addRecipes(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @PutMapping("/changeRecipe")
    public void changeRecipe(@RequestBody Recipe recipe) {
        recipeService.changeRecipe(recipe);
    }

    @DeleteMapping("/deleteRecipe")
    public void deleteRecipe(@RequestBody Recipe recipe) {
        recipeService.deleteRecipe(recipe);
    }

    @GetMapping("/printRecipes")
    public void printRecipes(@RequestBody Map<Long, Recipe> recipes) {
        recipeService.printAllRecipes(recipes);
    }
}
