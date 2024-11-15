package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.SignUpResponseDto;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String email, String password) {

        User user = new User(userName, email, password);

        User saveUser = userRepository.save(user);

        return new SignUpResponseDto(saveUser.getId(), saveUser.getUserName(), saveUser.getEmail());
    }
}
