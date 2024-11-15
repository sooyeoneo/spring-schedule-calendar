package com.example.springschedulecalendar.dto.user;

import lombok.Getter;

@Getter
public class SignUpResDto {
    private final Long id;
    private final String userName;
    private final String email;

    public SignUpResDto(Long id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
    }
}
