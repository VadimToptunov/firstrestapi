package com.vadimtoptunov.firstrestapi.model;

import com.vadimtoptunov.firstrestapi.entity.TodoEntity;
import lombok.Data;

@Data
public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public static Todo toModel(TodoEntity entity){
        Todo model = new Todo();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.isCompleted());
        return model;
    }
}
