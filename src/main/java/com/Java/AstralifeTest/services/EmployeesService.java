package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.Employees;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.EmployeesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeesService {
    @Autowired
    private EmployeesRepository employeesRepository;

    public ApiResponse getAll(){
        ApiResponse response = null;
        try {
            List<Employees> employees = employeesRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,employees);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse save(Employees employees){
        ApiResponse response = null;
        try {
            employees = employeesRepository.save(employees);
            response =new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,employees);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse update(long id, Employees updateEmployees){
        ApiResponse response = null;
        try {
            Optional<Employees> existingEmployee = employeesRepository.findById(id);
            if (existingEmployee.isPresent()) {
                updateEmployees.setId(id);
                employeesRepository.save(updateEmployees);
                response =new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateEmployees);
            }
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }
    public void deleteEmployees(long id){
        employeesRepository.deleteById(id);
    }


}
