package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.LoginResDto;
import com.example.springschedulecalendar.dto.user.SignUpResDto;
import com.example.springschedulecalendar.dto.user.UserResDto;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.schedule.ScheduleRepository;
import com.example.springschedulecalendar.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    // 유저 생성
    public SignUpResDto signUp(String userName, String email, String password) {

        User user = new User(userName, email, password);

        User saveUser = userRepository.save(user);

        return new SignUpResDto(saveUser.getId(), saveUser.getUserName(), saveUser.getEmail());
    }

    // 유저 id로 조회
    public UserResDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 id 입니다. ");
        }

        User findUser = optionalUser.get();
        return new UserResDto(findUser.getId(), findUser.getUserName(), findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt());
    }

    // 비밀번호 일치 여부 확인
    @Transactional
    public void matchPassword(Long id, String password) {

        User user = userRepository.findByIdOrElseThrow(id);
        if (!user.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀 번호가 일치하지 않습니다.");
        }
    }

    // 유저 삭제. 일정이 남아있는 경우 유저 삭제를 실행하지 않음(예외 처리)
    public void deleteUser(Long id, String password) {
        User findUser = userRepository.findByIdOrElseThrow(id);
        if (!scheduleRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "사용자와 연관된 일정이 존재합니다.");
        }
//        matchPassword(id, password); SQL을 사용하여 user를 조회하고 password가 같은 지 확인한다. SQL은 동작 속도를 느리게 만들어 사용을 지양.
        userRepository.delete(findUser);
    }

    // 유저 로그인
    @Override
    public LoginResDto login(String email, String password) {
        User findUser = userRepository.findUserByEmailOrElseThrow(email);
        if (!findUser.getPassword().equals(password)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀 번호가 일치하지 않습니다.");
        }
        return new LoginResDto(findUser.getId());
    }
}
