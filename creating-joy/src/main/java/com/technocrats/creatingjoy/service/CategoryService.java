
package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dto.CategoryDTO;

import java.util.List;


public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findByName(String categoryName);

}