package com.vadimtoptunov.firstrestapi.repository;

import com.vadimtoptunov.firstrestapi.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
