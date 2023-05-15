package com.openclassrooms.dataLayer.service;

import com.openclassrooms.dataLayer.repository.CategoryRepository;
import com.openclassrooms.dataLayer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    // on ajoute une méthode addCategory dans la classe CategoryService
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

}