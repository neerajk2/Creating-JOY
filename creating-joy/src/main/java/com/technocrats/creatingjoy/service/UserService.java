package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();
    User findById(int id);
    void save(User user);
    void deleteById(int id);
    User findByUserName(String userName);



}
