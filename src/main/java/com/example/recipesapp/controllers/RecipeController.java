package com.example.recipesapp.controllers;

import com.example.recipesapp.model.Ingredient;
import com.example.recipesapp.model.Recipe;
import com.example.recipesapp.services.RecipeService;
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
@RequestMapping("/recipe")
@Tag(name = "Рецепты", description = "Управление списком рецептов")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Получение рецепта по его id"
    )
    public Recipe getRecipes(@PathVariable Long id) {
        return recipeService.getRecipe(id);
    }

    @PostMapping
    @Operation(
            description = "Добавление новго рецепта"
    )
    public void addRecipes(@RequestBody Recipe recipe) {
        recipeService.addRecipe(recipe);
    }

    @PutMapping("/{id}")
    @Operation(
            description = "Изменение рецепта по его id"
    )
    public void changeRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipeService.changeRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    @Operation(
            description = "Удаление рецепта по его id"
    )
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }


    @GetMapping
    @Operation(
            description = "Получение списка всех рецептов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "рецепты получены",
                    content = {
                            @Content(
                                    mediaType = "recipes/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))

                            )
                    }
            )
    }
    )
    public String printRecipes(@RequestBody Map<Long, Recipe> recipes) {
        return recipeService.printAllRecipes(recipes);
    }
}
