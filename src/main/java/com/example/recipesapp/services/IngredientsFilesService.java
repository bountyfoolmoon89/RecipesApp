package com.example.recipesapp.services;

import java.io.File;
import java.nio.file.Path;

public interface IngredientsFilesService {

    void saveToFile(String json);

    File getDataFile();

    Path CreateTempIngredientsFile(String suffix);

    String readFromFile();

    void cleanDataFile();
}
