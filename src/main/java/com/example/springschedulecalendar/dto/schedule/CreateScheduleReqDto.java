package com.example.springschedulecalendar.dto.schedule;

import lombok.Getter;

@Getter
public class CreateScheduleReqDto {
    private final Long userId;
    private final String title;
    private final String contents;

    public CreateScheduleReqDto(Long userid, String title, String contents) {
        this.userId = userid;
        this.title = title;
        this.contents = contents;
    }
}
