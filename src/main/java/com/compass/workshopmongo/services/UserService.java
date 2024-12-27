package com.compass.workshopmongo.services;

import com.compass.workshopmongo.domain.User;
import com.compass.workshopmongo.repository.UserRepository;
import com.compass.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

        return user;
    }
}
