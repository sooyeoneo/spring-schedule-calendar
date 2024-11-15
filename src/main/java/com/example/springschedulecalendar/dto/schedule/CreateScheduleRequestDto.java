package com.example.springschedulecalendar.dto.schedule;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateScheduleRequestDto {

    private final Long userId;

    private final String title;

    private final String contents;

    public CreateScheduleRequestDto(Long userid, String title, String contents) {
        this.userId = userid;
        this.title = title;
        this.contents = contents;
    }
}
