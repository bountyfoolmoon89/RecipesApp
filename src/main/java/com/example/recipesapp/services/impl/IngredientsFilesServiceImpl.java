package com.example.recipesapp.services.impl;

import com.example.recipesapp.services.IngredientsFilesService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class IngredientsFilesServiceImpl implements IngredientsFilesService {

    @Value("${path.to.data.file.ingredients}")
    private String dataFilePath;

    @Value("${name.of.data.file.ingredients}")
    private String dataFileName;

    @Override
    public void saveToFile(String json){
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath, dataFileName), json);
        } catch (IOException e) {
        }
    }

    @Override
    public File getDataFile(){
        return new File(dataFilePath + "/" + dataFileName);
    }

    @Override
    public Path CreateTempIngredientsFile(String suffix){
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tempFile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public void cleanDataFile(){
        try {
            Path path = Path.of(dataFilePath, dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
