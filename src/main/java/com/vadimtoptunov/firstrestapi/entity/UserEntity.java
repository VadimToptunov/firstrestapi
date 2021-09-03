package com.vadimtoptunov.firstrestapi.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
    @Getter
    private String username;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @Getter
    private List<TodoEntity> todos;
}