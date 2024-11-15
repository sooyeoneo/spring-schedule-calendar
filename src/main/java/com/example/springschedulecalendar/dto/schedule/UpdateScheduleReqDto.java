package com.example.springschedulecalendar.dto.schedule;

import lombok.Getter;

@Getter
public class UpdateScheduleReqDto {
    private final String password;
    private final String title;
    private final String contents;

    public UpdateScheduleReqDto(String password, String title, String contents) {
        this.password = password;
        this.title = title;
        this.contents = contents;
    }
}
