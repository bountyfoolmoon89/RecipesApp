package com.example.recipesapp.services;

import java.io.File;
import java.nio.file.Path;

public interface IngredientsFilesService {

    boolean saveToFile(String json);

    File getDataFile();

    public Path CreateTempIngredientsFile(String suffix);

    public String readFromFile();

    public void cleanDataFile();
}
