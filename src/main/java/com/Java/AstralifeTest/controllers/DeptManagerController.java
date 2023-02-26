package com.Java.AstralifeTest.controllers;

import com.Java.AstralifeTest.models.entities.DeptManager;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.services.DeptrManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/astralif/api/deptManager")
public class DeptManagerController {

    @Autowired
    private DeptrManagerService deptrManagerService;

    @GetMapping("/all")
    public ApiResponse getAll(){
        return deptrManagerService.getAll();
    }
    @PostMapping("/add")
    public ApiResponse save(@RequestBody DeptManager deptManager){
        return deptrManagerService.save(deptManager);
    }

    @PostMapping("/update/{id}")
    public ApiResponse update(@PathVariable long id,
                              @RequestBody DeptManager deptManager){
        return deptrManagerService.update(id, deptManager);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        deptrManagerService.delete(id);
    }
}
