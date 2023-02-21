package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
import org.springframework.web.bind.annotation.*;


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


}
