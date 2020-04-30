package com.technocrats.creatingjoy.service;

import com.technocrats.creatingjoy.dao.CategoryRepository;
import com.technocrats.creatingjoy.dto.CategoryDTO;
import com.technocrats.creatingjoy.entity.Category;
import com.technocrats.creatingjoy.objectmapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional
    public List<CategoryDTO> findAll() {

        List<Category> categories = new ArrayList<>();
        categories = categoryRepository.findAll();

        List<CategoryDTO> categorieDTO = new ArrayList<>();

        for (Category category : categories) {

            categorieDTO.add(categoryMapper.convertToDto(category));
        }

        return categorieDTO;
    }


    @Override
    public CategoryDTO findByCategoryName(String categoryName) {
        return categoryMapper.convertToDto(categoryRepository.findByCategoryName(categoryName));
    }


}