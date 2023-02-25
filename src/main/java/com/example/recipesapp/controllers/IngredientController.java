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

    @GetMapping("/oneIngredient/{id}")
    public Ingredient getIngredients(@PathVariable Long id) {
        return ingredientService.getIngredient(id);
    }

    @PostMapping("/addingIngredients")
    public void addIngredients(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/changingIngredient/{id}")
    public void changeIngredients(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        ingredientService.changeIngredient(id, ingredient);
    }

    @DeleteMapping("/deletingIngredient/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    @GetMapping("/allIngredients")
    public void printIngredients(@RequestBody Map<Long, Ingredient> ingredients) {
        ingredientService.printAllIngredients(ingredients);
    }
}
