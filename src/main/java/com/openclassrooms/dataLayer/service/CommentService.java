package com.openclassrooms.dataLayer.service;

import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Iterable<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    // on ajoute une méthode addCategory dans la classe CategoryService
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

}