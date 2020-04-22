package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {


    List<User> getUsersByRole(String roleName);
    List<User> getUsersByCity(String cityName);



}
