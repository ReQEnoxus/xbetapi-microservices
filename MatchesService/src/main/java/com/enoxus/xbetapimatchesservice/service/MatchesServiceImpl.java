package com.enoxus.xbetapimatchesservice.service;

import com.enoxus.xbetapimatchesservice.dto.MatchDto;
import com.enoxus.xbetapimatchesservice.dto.MatchesSearchResult;
import com.enoxus.xbetapimatchesservice.entity.Match;
import com.enoxus.xbetapimatchesservice.repository.MatchesRepository;
import com.enoxus.xbetapimatchesservice.util.BetHelper;
import com.enoxus.xbetapimatchesservice.util.DateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchesServiceImpl implements MatchesService {

    @Autowired
    private DateHelper dateHelper;

    @Autowired
    private MatchesRepository matchesRepository;

    @Autowired
    private BetHelper betHelper;

    @Override
    public List<MatchDto> getAllByDate(String date) {
        Date initialDate = dateHelper.parse(date);
        Date dueDate = new Date(initialDate.getTime() + 86400000);

        return matchesRepository.findAllByDateBetween(initialDate, dueDate)
                .stream()
                .map(match -> MatchDto.builder()
                        .awayTeam(match.getAwayTeam())
                        .homeTeam(match.getHomeTeam())
                        .coefficients(betHelper.coefficientSet(match.getHomeTeam().getId(), match.getAwayTeam().getId()))
                        .id(match.getId())
                        .localizedDate(dateHelper.russianLocalized(match.getDate()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public MatchesSearchResult getByQuery(String query, String date, Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Match> dtos = matchesRepository.search(query, new Date(), new Date(dateHelper.parse(date).getTime() + 86400000), pageRequest);
        int count = dtos.getTotalPages();
        List<MatchDto> dtoList = dtos
                .stream()
                .map(match -> MatchDto.builder()
                        .awayTeam(match.getAwayTeam())
                        .homeTeam(match.getHomeTeam())
                        .coefficients(betHelper.coefficientSet(match.getHomeTeam().getId(), match.getAwayTeam().getId()))
                        .id(match.getId())
                        .localizedDate(dateHelper.russianLocalized(match.getDate()))
                        .build())
                .collect(Collectors.toList());

        return MatchesSearchResult.builder()
                .matches(dtoList)
                .pagesCount(count)
                .build();

    }

    @Override
    public Optional<MatchDto> getById(Long id) {
        return matchesRepository.findById(id).map(match -> MatchDto.builder()
                .awayTeam(match.getAwayTeam())
                .homeTeam(match.getHomeTeam())
                .coefficients(betHelper.coefficientSet(match.getHomeTeam().getId(), match.getAwayTeam().getId()))
                .id(match.getId())
                .localizedDate(dateHelper.russianLocalized(match.getDate()))
                .build());
    }
}