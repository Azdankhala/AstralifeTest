package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.Departments;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astralife/api")
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @GetMapping("/departments")
    public ApiResponse getAll(){
        return departmentsService.getAll();
    }
    @PostMapping("/addDepartment")
    public ApiResponse saveDepartments(@RequestBody Departments departments){
        return departmentsService.addDept(departments);
    }

    @PostMapping("/update/{deptNo}")
    public ApiResponse updateDepartments(@PathVariable long id,
                                       @RequestBody Departments departments){
        return departmentsService.updateDept(departments, id);
    }

    @DeleteMapping("/deleteDept/{deptNo}")
    public void deleteDepartments(@PathVariable long id){
        departmentsService.deleteDept(id);
    }
}
