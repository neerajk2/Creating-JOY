package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryRepository extends JpaRepository<Query,Integer>
{

    List<Query> findByCategoryId(int id);
    List<Query> findByRequestorId(int id);
}
