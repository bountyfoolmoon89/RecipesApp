package com.example.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {

    private static String name;

    private static int cookingMinutes;

    private static List<Object> ingredients = new ArrayList<>();

    private static List<String> steps = new ArrayList<>();

    public Recipe(String name, int cookingMinutes) {
        Recipe.name = name;
        Recipe.cookingMinutes = cookingMinutes;
    }

    public static String getName() {
        return name;
    }

    public static int getCookingMinutes() {
        return cookingMinutes;
    }

    public static List<Object> getIngredients() {
        return ingredients;
    }

    public static List<String> getSteps() {
        return steps;
    }

    public void setName(String name) {
        if (name.isBlank() | name.isEmpty()){
            throw new RuntimeException("Введите информациию");
        } else {
            Recipe.name = name;
        }
    }

    public void setCookingMinutes(int cookingMinutes) {
        if (cookingMinutes > 0){
            Recipe.cookingMinutes = cookingMinutes;
        }
    }
}
