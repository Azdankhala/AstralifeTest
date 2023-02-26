package com.Java.AstralifeTest.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse <T> {
    private int status;
    private String message;
    private T result;

    public ApiResponse(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

}
