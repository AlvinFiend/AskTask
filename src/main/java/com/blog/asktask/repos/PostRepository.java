package com.blog.asktask.repos;

import com.blog.asktask.domain.Post;
import com.blog.asktask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getByTitle(String title);

    void deleteByTitle(String title);

    void deleteById(long id);
}
