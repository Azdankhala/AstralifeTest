package com.Java.AstralifeTest.services;

import com.Java.AstralifeTest.constans.ApplicationConstant;
import com.Java.AstralifeTest.models.entities.Titles;
import com.Java.AstralifeTest.models.response.ApiResponse;
import com.Java.AstralifeTest.repositories.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitlesService {

    @Autowired
    private TitlesRepository titlesRepository;

    public ApiResponse getAll(){
        ApiResponse response = null;
        try {
            List<Titles> titles = titlesRepository.findAll();
            response = new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.SUCCESS_MESSAGE,titles);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse save(Titles titles){
        ApiResponse response = null;
        try {
            titles = titlesRepository.save(titles);
            response =new ApiResponse<>(ApplicationConstant.CREATED,ApplicationConstant.CREATED_SUCCESS,titles);
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }

    public ApiResponse update(long id, Titles updateTitles){
        ApiResponse response = null;
        try {
            Optional<Titles> existingTitles = titlesRepository.findById(id);
            if (existingTitles.isPresent()) {
                updateTitles.setId(id);
                titlesRepository.save(updateTitles);
                response =new ApiResponse<>(ApplicationConstant.SUCCESS,ApplicationConstant.UPDATED_SUCCESS,updateTitles);
            }
        }catch (Exception e){
            //exception handling
            String error = e.getMessage();
            response = new ApiResponse<>(ApplicationConstant.ER00,ApplicationConstant.INTERNAL_SERVER_ERROR,error);
        }
        return response;
    }
    public void delete(long id){
        titlesRepository.deleteById(id);
    }

}
