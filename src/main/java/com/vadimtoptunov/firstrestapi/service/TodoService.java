package com.vadimtoptunov.firstrestapi.service;

import com.vadimtoptunov.firstrestapi.entity.TodoEntity;
import com.vadimtoptunov.firstrestapi.entity.UserEntity;
import com.vadimtoptunov.firstrestapi.exceptions.UserAlreadyExistsException;
import com.vadimtoptunov.firstrestapi.model.Todo;
import com.vadimtoptunov.firstrestapi.repository.TodoRepo;
import com.vadimtoptunov.firstrestapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTask(TodoEntity todoEntity, Long userId) {
        Optional<UserEntity> userEntity = userRepo.findById(userId);
        userEntity.ifPresent(todoEntity::setUser);
        return Todo.toModel(todoRepo.save(todoEntity));
    }

    public Todo completeTask(Long userId) {
        TodoEntity todo = todoRepo.findById(userId).get();
        todo.setCompleted(!todo.isCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
