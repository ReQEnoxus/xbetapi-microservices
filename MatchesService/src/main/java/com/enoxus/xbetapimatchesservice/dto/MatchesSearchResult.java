package com.enoxus.xbetapimatchesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchesSearchResult {

    private List<MatchDto> matches;
    private int pagesCount;
}