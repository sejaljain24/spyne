package com.backend.spyne.controller;

//import com.example.discussionapp.models.Discussion;
//import com.example.discussionapp.services.DiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.spyne.entity.Discussion;
import com.backend.spyne.service.DiscussionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    @Autowired
    private DiscussionService discussionService;

    @PostMapping
    public ResponseEntity<?> createDiscussion(@RequestBody Discussion discussion) {
        return ResponseEntity.ok(discussionService.saveDiscussion(discussion));
    }

    @GetMapping
    public ResponseEntity<List<Discussion>> getAllDiscussions() {
        return ResponseEntity.ok(discussionService.findAllDiscussions());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Discussion>> searchDiscussionsByText(@RequestParam String text) {
        return ResponseEntity.ok(discussionService.findDiscussionsByText(text));
    }

    @GetMapping("/tags")
    public ResponseEntity<List<Discussion>> searchDiscussionsByTags(@RequestParam String tag) {
        return ResponseEntity.ok(discussionService.findDiscussionsByHashtags(tag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDiscussion(@PathVariable Long id, @RequestBody Discussion discussionDetails) {
        Optional<Discussion> discussion = discussionService.findDiscussionById(id);
        if (discussion.isPresent()) {
            Discussion existingDiscussion = discussion.get();
            existingDiscussion.setText(discussionDetails.getText());
            existingDiscussion.setImageUrl(discussionDetails.getImageUrl());
            existingDiscussion.setHashtags(discussionDetails.getHashtags());
            return ResponseEntity.ok(discussionService.saveDiscussion(existingDiscussion));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiscussion(@PathVariable Long id) {
        discussionService.deleteDiscussion(id);
        return ResponseEntity.ok().build();
    }
}
