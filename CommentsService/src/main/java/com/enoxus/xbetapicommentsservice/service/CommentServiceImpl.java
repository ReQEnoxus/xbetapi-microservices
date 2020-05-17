package com.enoxus.xbetapicommentsservice.service;

import com.enoxus.xbetapicommentsservice.dto.CommentDto;
import com.enoxus.xbetapicommentsservice.dto.ReplyDto;
import com.enoxus.xbetapicommentsservice.dto.UserDto;
import com.enoxus.xbetapicommentsservice.entity.Comment;
import com.enoxus.xbetapicommentsservice.repository.CommentRepository;
import com.enoxus.xbetapicommentsservice.repository.MatchesRepository;
import com.enoxus.xbetapicommentsservice.repository.ReplyRepository;
import com.enoxus.xbetapicommentsservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MatchesRepository matchRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CommentDto> getCommentsForMatch(Long matchId) {
        List<Comment> comments = commentRepository.getAllByMatchId(matchId);

        return comments.stream()
                .map(comment -> CommentDto.builder()
                        .id(comment.getId())
                        .owner(userRepository.getUserDtoByLogin(comment.getOwner().getLogin()))
                        .text(comment.getText())
                        .replies(replyRepository.getAllByParentId(comment.getId())
                                .stream()
                                .map(reply -> ReplyDto.builder()
                                        .owner(userRepository.getUserDtoByLogin(reply.getOwner().getLogin()))
                                        .text(reply.getText())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .collect(Collectors.toList());
    }
}
