package com.example.springschedulecalendar.dto.schedule;

import com.example.springschedulecalendar.entity.schedule.Schedule;

import lombok.Getter;

@Getter
public class ScheduleResDto {
    private final Long id;
    private final Long userId;
    private final String title;
    private final String contents;

    public ScheduleResDto(Long id, Long userId, String title, String contents) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.contents = contents;
    }

    public ScheduleResDto(Schedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUser().getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
    }
}
