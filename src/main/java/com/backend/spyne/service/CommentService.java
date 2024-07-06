package com.backend.spyne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.spyne.entity.Comment;
import com.backend.spyne.repo.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> findCommentsByDiscussionId(Long discussionId) {
        return commentRepository.findByDiscussionId(discussionId);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
    public Optional<Comment> findCommentById(Long id) {
        return commentRepository.findById(id);
    }
}
