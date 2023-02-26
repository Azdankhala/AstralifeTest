package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.DeptEmp;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.DeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astralife/api/deptEmp")
public class DeptEmpController {
    @Autowired
    private DeptEmpService deptEmpService;

    @GetMapping("/all")
    public ApiResponse getAll(){
        return deptEmpService.getAll();
    }
    @PostMapping("/add")
    public ApiResponse save(@RequestBody DeptEmp deptEmp){
        return deptEmpService.save(deptEmp);
    }

    @PostMapping("/update/{id}")
    public ApiResponse update(@PathVariable long id,
                                         @RequestBody DeptEmp deptEmp){
        return deptEmpService.update(id, deptEmp);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        deptEmpService.delete(id);
    }
}
