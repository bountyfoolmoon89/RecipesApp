package com.example.recipesapp.services;

public interface FilesService {

    boolean saveToFile(String json);

    public String readFromFile();
}
