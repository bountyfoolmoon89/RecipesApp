package com.example.recipesapp.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {

    private String name;

    private int cookingMinutes;

    private List<Ingredient> ingredients = new ArrayList<>();

    private List<Object> steps = new ArrayList<>();

    public Recipe(String name, int cookingMinutes, List ingredients, List steps) {
        this.name = name;
        this.cookingMinutes = cookingMinutes;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Object> getSteps() {
        return steps;
    }

    public void setName(String name) {
        if (name.isBlank() | name.isEmpty()){
            throw new RuntimeException("Введите информациию");
        } else {
            this.name = name;
        }
    }

    public void setCookingMinutes(int cookingMinutes) {
        if (cookingMinutes > 0){
            this.cookingMinutes = cookingMinutes;
        }
    }
}
