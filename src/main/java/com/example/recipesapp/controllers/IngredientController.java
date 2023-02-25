package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/getIngredients")
    public Ingredient getIngredients(@RequestParam Long numberOfIngredient) {
        return ingredientService.getIngredient(numberOfIngredient);
    }

    @PostMapping("/addIngredients")
    public void addIngredients(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/changeIngredient")
    public void changeIngredients(@RequestBody Ingredient ingredient) {
        ingredientService.changeIngredient(ingredient);
    }

    @DeleteMapping("/deleteIngredient")
    public void deleteIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.deleteIngredient(ingredient);
    }

    @GetMapping("/printIngredients")
    public void printIngredients(@RequestBody Map<Long, Ingredient> ingredients) {
        ingredientService.printAllIngredients(ingredients);
    }
}
