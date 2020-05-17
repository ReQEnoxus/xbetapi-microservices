package com.enoxus.xbetapicommentsservice.repository;

import com.enoxus.xbetapicommentsservice.dto.UserDto;
import com.enoxus.xbetapicommentsservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByLogin(String login);

    @Query("select new com.enoxus.xbetapicommentsservice.dto.UserDto(user.id," +
            " user.name," +
            " user.lastName," +
            " user.email," +
            " user.balance," +
            " avatar.storageFileName," +
            " user.login," +
            " user.state.name) from User user left join user.avatar as avatar where user.login = :login")
    UserDto getUserDtoByLogin(@Param("login") String login);
}