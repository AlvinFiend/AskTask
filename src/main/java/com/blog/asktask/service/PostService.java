package com.blog.asktask.service;

import com.blog.asktask.domain.Post;

import java.util.List;

public interface PostService {

    Post save(Post post);

    List<Post> getAll();

    List<Post> getByTitle(String title);

    void remove(Post post);

    void removeByTitle(String title);

    void removeById(long id);
    default void removeById(String id){
        this.removeById(Long.valueOf(id));
    }
}
