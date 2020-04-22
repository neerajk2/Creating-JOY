package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    List<Role> getRolesByUserName(String userName);
}
