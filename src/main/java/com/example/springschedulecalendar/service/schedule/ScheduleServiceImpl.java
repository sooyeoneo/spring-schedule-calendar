package com.example.springschedulecalendar.service.schedule;

import com.example.springschedulecalendar.dto.schedule.ScheduleResDto;
import com.example.springschedulecalendar.entity.schedule.Schedule;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.schedule.ScheduleRepository;
import com.example.springschedulecalendar.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Override
    public ScheduleResDto save(Long userId, String title, String contents) {

        User findUser = userRepository.findByIdOrElseThrow(userId);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResDto(schedule.getId(), userId, schedule.getTitle(), schedule.getContents());
    }

    // 일정 전체 조회
    @Override
    public List<ScheduleResDto> findAll() {
        return scheduleRepository.findAll().stream().map(ScheduleResDto::new).toList(); // ScheduleResponseDto 를 인자로 받는 생성자를 만들어짐.
    }

    // 일정 선택 조회
    @Override
    public ScheduleResDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        return new ScheduleResDto(
                schedule.getId(), schedule.getUser().getId(), schedule.getTitle(),schedule.getContents()
        );
    }

    // 일정 수정
    @Transactional
    @Override
    public ScheduleResDto update(Long id, Long userId, String title, String contents) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.updateSchedule(title, contents); // 수정일도 추가

        return new ScheduleResDto(schedule.getId(), schedule.getUser().getId(), schedule.getTitle(), schedule.getContents());
    }

    // 일정 삭제
    @Override
    public void delete(Long id){

        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(findSchedule);
    }
}
