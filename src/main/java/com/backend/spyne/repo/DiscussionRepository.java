package com.backend.spyne.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.spyne.entity.Discussion;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByHashtagsContaining(String hashtag);
    List<Discussion> findByTextContaining(String text);
}