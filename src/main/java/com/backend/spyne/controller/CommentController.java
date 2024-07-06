package com.backend.spyne.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.spyne.entity.Comment;
import com.backend.spyne.service.CommentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.saveComment(comment));
    }

    @GetMapping("/discussion/{discussionId}")
    public ResponseEntity<List<Comment>> getCommentsByDiscussionId(@PathVariable Long discussionId) {
        return ResponseEntity.ok(commentService.findCommentsByDiscussionId(discussionId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody Comment commentDetails) {
        Optional<Comment> comment = commentService.findCommentById(id);
        if (comment.isPresent()) {
            Comment existingComment = comment.get();
            existingComment.setText(commentDetails.getText());
            return ResponseEntity.ok(commentService.saveComment(existingComment));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}

