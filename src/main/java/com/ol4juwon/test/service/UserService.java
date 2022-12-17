package com.ol4juwon.test.service;

import java.util.List;

import com.ol4juwon.test.dto.UserDto;
import com.ol4juwon.test.users.Users;

public interface UserService {
    void saveUser(UserDto userDto);

    Users findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
