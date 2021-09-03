package com.vadimtoptunov.firstrestapi.controller;

import com.vadimtoptunov.firstrestapi.exceptions.NoSuchUserException;
import com.vadimtoptunov.firstrestapi.exceptions.UserAlreadyExistsException;
import com.vadimtoptunov.firstrestapi.handler.ResponseEntityHandler;
import com.vadimtoptunov.firstrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.vadimtoptunov.firstrestapi.entity.UserEntity;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity getUsers() {
        try {
            return ResponseEntityHandler.responseOk("Server is working!");
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }

    @GetMapping
    public ResponseEntity getOneUserById(@RequestParam Long id){
        try {
            return ResponseEntityHandler.responseOk(userService.getOneUser(id));
        }catch (NoSuchUserException exc){
            return ResponseEntity.badRequest().body(exc.getMessage());
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers(){
        try {
            return ResponseEntityHandler.responseOk(userService.getAllUsers());
        }catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }


    @PostMapping
    public ResponseEntity registerUser(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntityHandler.responseOk("User has been added.");
        } catch (UserAlreadyExistsException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntityHandler.responseOk(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }
}
