package com.technocrats.creatingjoy.dao;

import com.technocrats.creatingjoy.entity.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryRepository extends JpaRepository<Query,Integer>
{

    List<Query> getQueriesByCategory(String categoryName);

}
