package com.blog.asktask.service;

import com.blog.asktask.domain.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);

    List<Post> getAll();

    List<Post> getByTitle(String title);
}
