package com.example.springschedulecalendar.controller;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleRequestDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResponseDto;
import com.example.springschedulecalendar.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody CreateScheduleRequestDto dto) {

        ScheduleResponseDto scheduleResponseDto =
                ScheduleService.save(
                        dto.getUserId(),
                        dto.getTitle(),
                        dto.getContents()
                );

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
