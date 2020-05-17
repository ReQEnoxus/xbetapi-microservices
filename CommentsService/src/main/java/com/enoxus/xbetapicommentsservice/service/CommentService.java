package com.enoxus.xbetapicommentsservice.service;

import com.enoxus.xbetapicommentsservice.dto.CommentDto;
import com.enoxus.xbetapicommentsservice.dto.UserDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getCommentsForMatch(Long matchId);
}