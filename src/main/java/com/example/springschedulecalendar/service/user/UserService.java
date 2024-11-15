package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.SignUpResponseDto;

public interface UserService {
    SignUpResponseDto signUp(String userName, String password, String email);

}
