package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleRequestDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResponseDto;

public interface ScheduleService {
    ScheduleResponseDto save(Long userId, String title, String contents);
}
