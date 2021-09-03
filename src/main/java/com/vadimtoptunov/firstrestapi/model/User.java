package com.vadimtoptunov.firstrestapi.model;

import com.vadimtoptunov.firstrestapi.entity.UserEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
    public Long id;
    public String username;
    public List<Todo> todos;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }
}
