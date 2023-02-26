package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.Titles;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astralife/api/titles")
public class TitlesController {

    @Autowired
    private TitlesService titlesService;

    @GetMapping("/all")
    public ApiResponse getAll(){
        return titlesService.getAll();
    }
    @PostMapping("/add")
    public ApiResponse save(@RequestBody Titles titles){
        return titlesService.save(titles);
    }

    @PostMapping("/update/{id}")
    public ApiResponse update(@PathVariable long id,
                              @RequestBody Titles titles){
        return titlesService.update(id, titles);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        titlesService.delete(id);
    }
}
