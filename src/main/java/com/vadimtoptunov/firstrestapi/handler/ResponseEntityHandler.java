package com.vadimtoptunov.firstrestapi.handler;

import org.springframework.http.ResponseEntity;

public class ResponseEntityHandler {

    public static ResponseEntity<Object> responseOk(Object message){
        return ResponseEntity.ok().body(message);
    }

    public static ResponseEntity<String> responseError(Exception exception){
        return ResponseEntity.badRequest().body(String.format("An error occurred: ", exception.getMessage()));
    }
}
