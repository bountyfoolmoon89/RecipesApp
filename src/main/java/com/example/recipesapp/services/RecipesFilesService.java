package com.example.recipesapp.services;

public interface RecipesFilesService {

    boolean saveToFile(String json);

    public String readFromFile();
}
