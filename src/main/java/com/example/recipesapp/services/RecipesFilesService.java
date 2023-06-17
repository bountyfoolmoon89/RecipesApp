package com.example.recipesapp.services;

import java.io.File;
import java.nio.file.Path;

public interface RecipesFilesService {

    void saveToFile(String json);

    File getDataFile();

    public Path CreateTempRecipesFile(String suffix);

    public String readFromFile();

    public void cleanDataFile();
}
