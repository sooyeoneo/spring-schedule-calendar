package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private final String userName;
    private final String email;
    private final String password;

    public SignUpRequestDto(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
