package com.example.springschedulecalendar.service;

import com.example.springschedulecalendar.dto.SignUpResponseDto;

public interface UserService {
    SignUpResponseDto signUp(String userName, String password, String email);

}
