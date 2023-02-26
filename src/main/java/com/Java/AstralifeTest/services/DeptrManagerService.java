package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.DeptManager;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeptrManagerService {

    @Autowired
    private DeptManagerRepository deptManagerRepository;

    public ApiResponse getAll(){
        ApiResponse response = null;
        try {
            List<DeptManager> deptManagers = deptManagerRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,deptManagers);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse save(DeptManager deptManager){
        ApiResponse response = null;
        try {
            deptManager = deptManagerRepository.save(deptManager);
            response =new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,deptManager);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse update(long id, DeptManager updateDeptManager){
        ApiResponse response = null;
        try {
            Optional<DeptManager> existingDeptManager = deptManagerRepository.findById(id);
            if (existingDeptManager.isPresent()) {
                updateDeptManager.setId(id);
                deptManagerRepository.save(updateDeptManager);
                response =new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateDeptManager);
            }
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }
    public void delete(long id){
        deptManagerRepository.deleteById(id);
    }

}
