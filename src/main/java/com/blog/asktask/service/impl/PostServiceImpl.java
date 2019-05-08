package com.blog.asktask.service.impl;

import com.blog.asktask.domain.Post;
import com.blog.asktask.repos.PostRepository;
import com.blog.asktask.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post save(Post post) {
        return repository.save(post);
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> getByTitle(String title) {
        return repository.getByTitle(title);
    }
}
