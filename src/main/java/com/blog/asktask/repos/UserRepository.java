package com.blog.asktask.repos;

import com.blog.asktask.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getById(long id);

    User findByUsername(String username);
}
