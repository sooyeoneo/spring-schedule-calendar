package com.example.springschedulecalendar.dto.schedule;

public class ScheduleResponseDto {

    private final Long id;

    private final Long userId;

    private final String title;

    private final String contents;

    public ScheduleResponseDto(Long id, Long userId, String title, String contents) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }
}