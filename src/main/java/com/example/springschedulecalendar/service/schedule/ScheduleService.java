package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.ScheduleResDto;

import java.util.List;

public interface ScheduleService {
    ScheduleResDto save(Long userId, String title, String contents);
    List<ScheduleResDto> findAll();
    ScheduleResDto findById(Long id);
    ScheduleResDto update(Long id, Long userId, String title, String contents);
    void delete(Long id);
}
