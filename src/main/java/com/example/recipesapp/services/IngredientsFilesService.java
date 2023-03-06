package com.example.recipesapp.services;

public interface IngredientsFilesService {

    boolean saveToFile(String json);

    public String readFromFile();
}
