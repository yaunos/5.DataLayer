package com.openclassrooms.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.dataLayer.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {


}