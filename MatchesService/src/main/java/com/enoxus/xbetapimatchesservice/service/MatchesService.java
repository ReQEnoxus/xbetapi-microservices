package com.enoxus.xbetapimatchesservice.service;

import com.enoxus.xbetapimatchesservice.dto.MatchDto;
import com.enoxus.xbetapimatchesservice.dto.MatchesSearchResult;

import java.util.List;
import java.util.Optional;

public interface MatchesService {

    List<MatchDto> getAllByDate(String date);
    MatchesSearchResult getByQuery(String query, String date, Integer page, Integer size);
    Optional<MatchDto> getById(Long id);
}