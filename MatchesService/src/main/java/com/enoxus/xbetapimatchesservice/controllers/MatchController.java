package com.enoxus.xbetapimatchesservice.controllers;

import com.enoxus.xbetapimatchesservice.dto.MatchDto;
import com.enoxus.xbetapimatchesservice.dto.MatchesSearchResult;
import com.enoxus.xbetapimatchesservice.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchController {

    @Autowired
    private MatchesService matchesService;

    @GetMapping("/search")
    public ResponseEntity<MatchesSearchResult> search(String query, String date, Integer page, Integer size) {
        return ResponseEntity.ok(matchesService.getByQuery(query, date, page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getById(@PathVariable Long id) {
        return ResponseEntity.of(matchesService.getById(id));
    }
}
