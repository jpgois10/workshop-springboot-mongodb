package com.compass.workshopmongo.resources;

import com.compass.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {
    private static final long serialVersionUID = 1L;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
//        List<User> list = new ArrayList<>();
//        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(Arrays.asList(maria, alex));
    }
}
