package com.example.springschedulecalendar.controller;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleReqDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResDto;
import com.example.springschedulecalendar.dto.schedule.UpdateScheduleReqDto;
import com.example.springschedulecalendar.dto.user.UserResDto;
import com.example.springschedulecalendar.service.schedule.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResDto> createSchedule(@RequestBody CreateScheduleReqDto dto) {

        ScheduleResDto scheduleResDto =
                scheduleService.save(
                        dto.getUserId(),
                        dto.getTitle(),
                        dto.getContents()
                );

        return new ResponseEntity<>(scheduleResDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResDto>> findAll() {
        List<ScheduleResDto> scheduleResDto = scheduleService.findAll();

        return new ResponseEntity<>(scheduleResDto, HttpStatus.OK);
    }

    // 일정 선택 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResDto> findScheduleById(@PathVariable Long id) {
        ScheduleResDto scheduleResDto = scheduleService.findById(id);

        return new ResponseEntity<>(scheduleResDto, HttpStatus.OK);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleReqDto dto,
            @SessionAttribute(name = "LOGIN_USER") UserResDto userResDto
    ) {
        ScheduleResDto scheduleResDto = scheduleService.update(id, userResDto.getId(), dto.getTitle(), dto.getContents());
        return new ResponseEntity<>(scheduleResDto, HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id){
        scheduleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
