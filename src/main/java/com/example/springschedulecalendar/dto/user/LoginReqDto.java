package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class LoginReqDto {

    private final String email;
    private final String password;

    public LoginReqDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
