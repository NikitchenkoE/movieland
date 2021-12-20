package com.repository;

import com.entity.User;

public interface UserRepository {
    User getUserByEmail(String email);
}
