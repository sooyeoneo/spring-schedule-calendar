package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class LoginResDto {

    private final Long userId;

    public LoginResDto(Long userId) {
        this.userId = userId;
    }
}
