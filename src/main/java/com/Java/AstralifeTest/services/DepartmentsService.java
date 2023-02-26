package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.Departments;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentsService {
    @Autowired
    private DepartmentsRepository departmentsRepository;

    public ApiResponse  getAll(){
        ApiResponse response = null;
        try {
            List<Departments> departments = departmentsRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,departments);
        }catch (Exception e){
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse addDept(Departments departments){
        ApiResponse response = null;
        try {
            departments = departmentsRepository.save(departments);
            response = new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,departments);
        }
        catch (Exception e){
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse updateDept(Departments updateDept,long id){
        ApiResponse response = null;
        try {
            Departments exist = departmentsRepository.findById(id);
            if (exist != null){
                updateDept.setId(id);
                departmentsRepository.save(updateDept);
                response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateDept);
            }
        }
        catch (Exception e){
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public void deleteDept(long id){
        departmentsRepository.deleteById(id);
    }
}
