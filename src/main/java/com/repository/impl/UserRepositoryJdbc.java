package com.repository.impl;

import com.entity.User;
import com.repository.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@AllArgsConstructor
@Repository
public class UserRepositoryJdbc implements com.repository.UserRepository {
    private static final String SELECT_USER_BY_EMAIL = "SELECT userid, userPersonalDetails, email, password, role FROM users WHERE email=:email";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserMapper userMapper = new UserMapper();

    @Override
    public User getUserByEmail(String email) {
        return namedParameterJdbcTemplate.queryForObject(SELECT_USER_BY_EMAIL, Collections.singletonMap("email", email), userMapper);
    }
}
