package com.example.springschedulecalendar.controller;

import com.example.springschedulecalendar.dto.SignUpRequestDto;
import com.example.springschedulecalendar.dto.SignUpResponseDto;
import com.example.springschedulecalendar.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto dto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(dto.getUserName(), dto.getEmail(), dto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }
}
