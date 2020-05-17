package com.enoxus.xbetapicommentsservice.repository;

import com.enoxus.xbetapicommentsservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> getAllByMatchId(Long matchId);
}