package com.compass.workshopmongo.services;

import com.compass.workshopmongo.domain.User;
import com.compass.workshopmongo.dto.UserDTO;
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
        User obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

        return obj;
    }

    public User insert(User obj) {
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
