package com.openclassrooms.dataLayer.repository;

import com.openclassrooms.dataLayer.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}