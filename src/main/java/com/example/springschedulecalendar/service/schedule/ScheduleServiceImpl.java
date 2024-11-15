package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleRequestDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResponseDto;
import com.example.springschedulecalendar.entity.schedule.Schedule;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.schedule.ScheduleRepository;
import com.example.springschedulecalendar.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    @Override
    public ScheduleResponseDto save(Long userId, CreateScheduleRequestDto dto) {

        User findUser = userRepository.findUserOrElseThrow(userId);

        Schedule schedule = new Schedule(dto.getTitle(), dto.getContents());
        scheduleRepository.save(schedule);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), userId, schedule.getTitle(), schedule.getContents());
    }
}
