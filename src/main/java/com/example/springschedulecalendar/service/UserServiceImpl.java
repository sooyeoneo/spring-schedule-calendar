package com.example.springschedulecalendar.service;

import com.example.springschedulecalendar.dto.SignUpResponseDto;
import com.example.springschedulecalendar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public static SignUpResponseDto signUp(String userName, String email, String password) {

        User user = new User(userName, email, password);

        User saveUser = userRepositroy.save(user);

        return new SignUpResponseDto(saveUser.getId(), saveUser.getUserName(), saveUser.getEmail());
    }
}
