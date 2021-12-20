package com.repository.mapper;


import com.entity.User;
import com.entity.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("userID"))
                .nickname(resultSet.getString("userPersonalDetails"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .userRole(UserRole.valueOf(resultSet.getString("role")))
                .build();
    }
}
