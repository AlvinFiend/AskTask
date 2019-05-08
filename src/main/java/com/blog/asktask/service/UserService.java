package com.blog.asktask.service;

import com.blog.asktask.domain.Post;
import com.blog.asktask.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);

    List<User> getAll();

    void remove(User user);

    User getByUsername(String username);

    List<Post> getPostsByUserId(long id);

    default List<Post> getPostsByUserId(String id){
        return this.getPostsByUserId(Long.valueOf(id));
    }

    default boolean isExist(User user) {
        return getAll().contains(user);
    }
}
