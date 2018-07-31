package com.sports.repository;

import com.sports.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by farhans on 7/30/18.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}