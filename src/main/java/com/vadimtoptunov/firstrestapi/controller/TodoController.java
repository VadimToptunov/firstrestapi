package com.vadimtoptunov.firstrestapi.controller;

import com.vadimtoptunov.firstrestapi.entity.TodoEntity;
import com.vadimtoptunov.firstrestapi.handler.ResponseEntityHandler;
import com.vadimtoptunov.firstrestapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todoEntity,
                                     @RequestParam Long userId){
        try {
            return ResponseEntityHandler.responseOk(todoService.createTask(todoEntity, userId));
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestParam Long userId){
        try {
            return ResponseEntityHandler.responseOk(todoService.completeTask(userId));
        } catch (Exception e) {
            return ResponseEntityHandler.responseError(e);
        }
    }
}
