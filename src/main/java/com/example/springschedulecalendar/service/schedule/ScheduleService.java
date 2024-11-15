package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleRequestDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResponseDto save(Long userId, String title, String contents);
    List<ScheduleResponseDto> findAll();
    ScheduleResponseDto findById(Long id);
    ScheduleResponseDto update(Long id, Long userId, String title, String contents);
    void delete(Long id);
}
