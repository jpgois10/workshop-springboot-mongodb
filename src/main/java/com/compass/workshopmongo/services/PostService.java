package com.compass.workshopmongo.services;

import com.compass.workshopmongo.domain.Post;

import com.compass.workshopmongo.repository.PostRepository;
import com.compass.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAll() {
        return repository.findAll();
    }

    public Post findById(String id) {
        Post obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));

        return obj;
    }

    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        //Acrescentando 1(24horas) dia à data máxima para cálculo de comparação do post
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
