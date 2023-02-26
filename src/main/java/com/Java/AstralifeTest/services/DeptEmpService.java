package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.DeptEmp;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.DeptEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptEmpService {

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    public ApiResponse getAll(){
        ApiResponse response = null;
        try {
            List<DeptEmp> deptEmps = deptEmpRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,deptEmps);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse save(DeptEmp deptEmp){
        ApiResponse response = null;
        try {
            deptEmp = deptEmpRepository.save(deptEmp);
            response =new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,deptEmp);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse update(long id, DeptEmp updateDeptEmp){
        ApiResponse response = null;
        try {
            Optional<DeptEmp> existingEmployee = deptEmpRepository.findById(id);
            if (existingEmployee.isPresent()) {
                updateDeptEmp.setId(id);
                deptEmpRepository.save(updateDeptEmp);
                response =new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateDeptEmp);
            }
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }
    public void delete(long id){
        deptEmpRepository.deleteById(id);
    }

}
