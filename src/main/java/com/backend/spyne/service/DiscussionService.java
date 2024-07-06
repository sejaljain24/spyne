package com.backend.spyne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.spyne.entity.Discussion;
import com.backend.spyne.repo.DiscussionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;

    public Discussion saveDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }

    public List<Discussion> findDiscussionsByHashtags(String hashtag) {
        return discussionRepository.findByHashtagsContaining(hashtag);
    }

    public List<Discussion> findDiscussionsByText(String text) {
        return discussionRepository.findByTextContaining(text);
    }

    public void deleteDiscussion(Long id) {
        discussionRepository.deleteById(id);
    }
    public Optional<Discussion> findDiscussionById(Long id) {
        return discussionRepository.findById(id);
    }
    public List<Discussion> findAllDiscussions() {
        return discussionRepository.findAll();
    }
}
