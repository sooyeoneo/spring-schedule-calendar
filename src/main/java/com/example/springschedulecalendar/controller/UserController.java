package com.example.springschedulecalendar.controller;

import com.example.springschedulecalendar.dto.user.SignUpRequestDto;
import com.example.springschedulecalendar.dto.user.SignUpResponseDto;
//import com.example.springschedulecalendar.dto.user.UpdatePasswordRequestDto;
import com.example.springschedulecalendar.dto.user.UserResponseDto;
import com.example.springschedulecalendar.service.user.UserServiceImpl;
import com.mysql.cj.x.protobuf.Mysqlx;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.OutputKeys;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Void> updatePassword(
//            @PathVariable Long id,
//            @RequestBody UpdatePasswordRequestDto requestDto
//    ) {
//        UserServiceImpl.updatePassword(id, requestDto.getOldPassword(),requestDto.getNewPassword());
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestBody DeleteUserRequestDto dto) {
        userService.deleteUser(id, dto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
