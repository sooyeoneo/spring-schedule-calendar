package com.example.springschedulecalendar.dto.schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private final String password;
    private final String title;
    private final String contents;

    public UpdateScheduleRequestDto(String password, String title, String contents) {
        this.password = password;
        this.title = title;
        this.contents = contents;
    }
}
