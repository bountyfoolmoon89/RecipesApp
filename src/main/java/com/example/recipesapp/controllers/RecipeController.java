package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import com.example.recipesapp.services.impl.RecipeServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/getRecipe")
    public void getRecipes(@RequestParam Long numberOfRecipe) {
        recipeService.getRecipe(numberOfRecipe);
    }

    @PutMapping("/addRecipes")
    public void addRecipes(@RequestParam String name, @RequestParam int cookingMinutes) {
        RecipeServiceImpl.addRecipe(new Recipe(name, cookingMinutes));
    }

    @GetMapping("/getIngredients")
    public void getIngredients(@RequestParam Long numberOfIngredient) {
        recipeService.getIngredient(numberOfIngredient);
    }

    @PutMapping("/addIngredients")
    public void addIngredients(@RequestParam String name, @RequestParam int amount, @RequestParam String unit) {
        RecipeServiceImpl.addIngredient(new Ingredient(name, amount, unit));
    }

}
