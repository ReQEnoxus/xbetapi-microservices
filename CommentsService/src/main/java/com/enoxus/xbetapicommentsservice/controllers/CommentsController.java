package com.enoxus.xbetapicommentsservice.controllers;

import com.enoxus.xbetapicommentsservice.dto.CommentDto;
import com.enoxus.xbetapicommentsservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @GetMapping("{matchId}")
    public ResponseEntity<List<CommentDto>> commentsForMatch(@PathVariable Long matchId) {
        return ResponseEntity.ok(commentService.getCommentsForMatch(matchId));
    }
}