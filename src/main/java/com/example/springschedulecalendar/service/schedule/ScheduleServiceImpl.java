package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.CreateScheduleRequestDto;
import com.example.springschedulecalendar.dto.schedule.ScheduleResponseDto;
import com.example.springschedulecalendar.entity.schedule.Schedule;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.schedule.ScheduleRepository;
import com.example.springschedulecalendar.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Override
    public ScheduleResponseDto save(Long userId, String title, String contents) {

        User findUser = userRepository.findByIdOrElseThrow(userId);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(schedule.getId(), userId, schedule.getTitle(), schedule.getContents());
    }

    // 일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
    }

    // 일정 선택 조회
    @Override
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResponseDto(
                schedule.getId(), schedule.getUserId(), schedule.getTitle(),schedule.getContents()
        );
    }

    // 일정 수정
    @Transactional
    @Override
    public ScheduleResponseDto update(Long id, Long userId, String title, String contents) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.updateSchedule(title, contents); // 수정일도 추가

        return new ScheduleResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getContents());
    }

    // 일정 삭제
    @Override
    public void delete(Long id, String password){

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        matchPassword(findSchedule.getUserId(),password);
        scheduleRepository.delete(findSchedule);
    }

    // 비밀 번호 일치 여부 확인
    private void matchPassword(String email, String password) {
        User user = userRepository.findUserByEmailOrElseThrow(email);
        if (!matches(password, user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀 번호가 일치하지 않습니다.");
        }

    }
}
