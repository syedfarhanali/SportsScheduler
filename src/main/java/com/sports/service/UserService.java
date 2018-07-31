package com.sports.service;

import com.sports.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by farhans on 7/30/18.
 */
public interface UserService {

    public void save(User user);
    public User findByUsername(String username);
    public void autologin(String username, String password);

    @Transactional(readOnly = true)
    User getCurrentUser();
}
