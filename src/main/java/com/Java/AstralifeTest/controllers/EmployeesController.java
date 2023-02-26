package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.Employees;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/astralife/api")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/employess")
    public ApiResponse getAll(){
        return employeesService.getAll();
    }

    @PostMapping("/addEmployee")
    public ApiResponse saveEmployees(@RequestBody Employees employees){
        return employeesService.save(employees);
    }

    @PostMapping("/update/{empNo}")
    public ApiResponse updateEmployees(@PathVariable long id,
                                       @RequestBody Employees employees){
        return employeesService.update(id,employees);
    }

    @DeleteMapping("/deleteEmployee/{empNo}")
    public void deleteEmployees(@PathVariable long id){
        employeesService.deleteEmployees(id);
    }


}
