package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class SignUpReqDto {
    private final String userName;
    private final String email;
    private final String password;

    public SignUpReqDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
