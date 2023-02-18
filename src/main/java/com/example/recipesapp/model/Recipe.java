package com.example.recipesapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {

    private String name;

    private int cookingMinutes;

    private List<Object> ingredients = new ArrayList<>();

    private List<String> steps = new ArrayList<>();

    public Recipe(String name, int cookingMinutes) {
        this.name = name;
        this.cookingMinutes = cookingMinutes;
    }

    public String getName() {
        return name;
    }

    public int getCookingMinutes() {
        return cookingMinutes;
    }

    public List<Object> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
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
