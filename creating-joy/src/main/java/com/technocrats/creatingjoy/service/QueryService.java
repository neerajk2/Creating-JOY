package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dto.QueryDTO;

import java.util.List;

public interface QueryService {

    List<QueryDTO> findAll();
    QueryDTO findById(int id);
    void save(QueryDTO queryDTO);
    void deleteById(int id);

    List<QueryDTO> findByCategoryId(int id);
    List<QueryDTO> findByRequestorId(int id);



}
