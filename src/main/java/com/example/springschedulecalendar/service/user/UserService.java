package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.SignUpResponseDto;
import com.example.springschedulecalendar.dto.user.UserResponseDto;

public interface UserService {

    SignUpResponseDto signUp(String userName, String password, String email);

    UserResponseDto findById(Long id);
}
