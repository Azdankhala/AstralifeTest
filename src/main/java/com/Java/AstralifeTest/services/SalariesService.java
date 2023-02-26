package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.Salaries;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.SalariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;

    public ApiResponse getAll(){
        ApiResponse response = null;
        try {
            List<Salaries> salaries = salariesRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,salaries);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse save(Salaries salaries){
        ApiResponse response = null;
        try {
            salaries = salariesRepository.save(salaries);
            response =new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,salaries);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse update(long id, Salaries updateSalaries){
        ApiResponse response = null;
        try {
            Optional<Salaries> existingSalaries = salariesRepository.findById(id);
            if (existingSalaries.isPresent()) {
                updateSalaries.setId(id);
                salariesRepository.save(updateSalaries);
                response =new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateSalaries);
            }
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }
    public void delete(long id){
        salariesRepository.deleteById(id);
    }

}
