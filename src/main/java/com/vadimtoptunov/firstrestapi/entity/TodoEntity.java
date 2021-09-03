package com.vadimtoptunov.firstrestapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @Getter
    @Setter
    private UserEntity user;
}
