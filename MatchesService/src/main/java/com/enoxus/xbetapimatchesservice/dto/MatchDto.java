package com.enoxus.xbetapimatchesservice.dto;

import com.enoxus.xbetapimatchesservice.entity.CoefficientSet;
import com.enoxus.xbetapimatchesservice.entity.Team;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MatchDto {
    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private CoefficientSet coefficients;
    private String localizedDate;
}