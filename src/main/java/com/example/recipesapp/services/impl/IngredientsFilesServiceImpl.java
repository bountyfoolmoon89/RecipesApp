package com.example.recipesapp.services.impl;

import com.example.recipesapp.services.IngredientsFilesService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IngredientsFilesServiceImpl implements IngredientsFilesService {

    @Value("${path.to.data.file.ingredients}")
    private String dataFilePath;

    @Value("${name.of.data.file.ingredients}")
    private String dataFileName;

    @Override
    public boolean saveToFile(String json){
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFile(){
        try {
            return Files.readString(Path.of(dataFilePath, dataFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cleanDataFile(){
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
