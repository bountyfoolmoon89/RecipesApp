package com.example.recipesapp.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Threshold;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Тест", description = "Проверка работоспособности программы")
public class TestController {

    @GetMapping("/start")
    public String appStarted(){
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String appInfo(){
        return "Имя ученика: Егор. Название проекта: RecipesApp. Дата создания проекта: 06.02.2023. Проект для хранения рецептов";
    }
}
