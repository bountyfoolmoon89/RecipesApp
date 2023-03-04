package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredient")
@Tag(name = "Ингредиенты", description = "Управление списком ингредиентов")
public class IngredientController {

    private final IngredientService ingredientService;


    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Получение ингредиента по его id"
    )
    public Ingredient getIngredients(@PathVariable Long id) {
        return ingredientService.getIngredient(id);
    }

    @PostMapping
    public void addIngredients(@RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

    @PutMapping("/{id}")
    public void changeIngredients(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        ingredientService.changeIngredient(id, ingredient);
    }

    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
    }

    @GetMapping
    @Operation(
            description = "Получение списка всех ингредиентов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиенты получены",
                    content = {
                            @Content(
                                    mediaType = "ingredients/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))

                            )
                    }
            )
    }
    )
    public void printIngredients(@RequestBody Map<Long, Ingredient> ingredients) {
        ingredientService.printAllIngredients(ingredients);
    }
}
