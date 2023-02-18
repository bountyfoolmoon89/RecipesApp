package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/getIngredients")
    public Long getIngredients(@RequestParam Long numberOfIngredient) {
        ingredientService.getIngredient(numberOfIngredient);
        return numberOfIngredient;
    }

    @PostMapping("/addIngredients")
    public void addIngredients(@RequestParam String name, @RequestParam int amount, @RequestParam String unit) {
        ingredientService.addIngredient(new Ingredient(name, amount, unit));
    }

}
