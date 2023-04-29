package com.example.recipesapp.controllers;

import com.example.recipesapp.services.RecipesFilesService;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.management.RuntimeErrorException;
import java.io.*;

@RestController
@RequestMapping("/recipesFiles")
public class RecipesFilesController {

    private final RecipesFilesService recipesFilesService;

    public RecipesFilesController(RecipesFilesService recipesFilesService) {
        this.recipesFilesService = recipesFilesService;
    }

    @GetMapping("/exportRecipes")
    public ResponseEntity<InputStreamResource> downloadDataFile() throws RuntimeErrorException, FileNotFoundException {
        File file = recipesFilesService.getDataFile();

        if (file.exists()) {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(file.length())
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"Recipes.json\"")
                    .body(resource);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping(value = "/importRecipes", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadDataFile(@RequestParam MultipartFile file){
        recipesFilesService.cleanDataFile();
        File dataFile = recipesFilesService.getDataFile();

        try (FileOutputStream fos = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
