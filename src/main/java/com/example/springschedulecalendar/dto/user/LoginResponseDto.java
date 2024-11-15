package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private final Long userId;

    public LoginResponseDto(Long userId) {
        this.userId = userId;
    }
}
