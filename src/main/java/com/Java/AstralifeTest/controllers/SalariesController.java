package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.Salaries;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astralife/api/salaries")
public class SalariesController {

    @Autowired
    private SalariesService salariesService;

    @GetMapping("/all")
    public ApiResponse getAll(){
        return salariesService.getAll();
    }
    @PostMapping("/add")
    public ApiResponse save(@RequestBody Salaries salaries){
        return salariesService.save(salaries);
    }

    @PostMapping("/update/{id}")
    public ApiResponse update(@PathVariable long id,
                              @RequestBody Salaries salaries){
        return salariesService.update(id, salaries);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        salariesService.delete(id);
    }
}
