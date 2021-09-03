package com.vadimtoptunov.firstrestapi.service;

import com.vadimtoptunov.firstrestapi.entity.UserEntity;
import com.vadimtoptunov.firstrestapi.exceptions.NoSuchUserException;
import com.vadimtoptunov.firstrestapi.exceptions.UserAlreadyExistsException;
import com.vadimtoptunov.firstrestapi.model.User;
import com.vadimtoptunov.firstrestapi.repository.TodoRepo;
import com.vadimtoptunov.firstrestapi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if(userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExistsException("The user already exists.");
        }
            return userRepo.save(user);
    }

    public User getOneUser(Long id) throws NoSuchUserException {
        Optional<UserEntity> user = userRepo.findById(id);
        if (user.isPresent()) {
            return User.toModel(user.get());
        }else {
            throw new NoSuchUserException("The user have not been created yet.");
        }
    }

    public List<User> getAllUsers() {
        List<User> models = new ArrayList<>();
        userRepo.findAll().forEach(userEntity -> models.add(User.toModel(userEntity)));
        return models;
    }

    public Long deleteUser(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
