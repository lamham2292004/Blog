package com.mycompany.blog.Repository;


import com.mycompany.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByEmail(String email);
    boolean existsByPassword(String password);
    Optional<User> findByEmail(String email);
}