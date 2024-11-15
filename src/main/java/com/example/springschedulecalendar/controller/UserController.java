package com.example.springschedulecalendar.controller;

import com.example.springschedulecalendar.dto.user.DeleteUserRequestDto;
import com.example.springschedulecalendar.dto.user.LoginRequestDto;
import com.example.springschedulecalendar.dto.user.LoginResponseDto;
import com.example.springschedulecalendar.dto.user.SignUpRequestDto;
import com.example.springschedulecalendar.dto.user.SignUpResponseDto;
//import com.example.springschedulecalendar.dto.user.UpdatePasswordRequestDto;
import com.example.springschedulecalendar.dto.user.UserResponseDto;
import com.example.springschedulecalendar.service.user.UserService;
import com.example.springschedulecalendar.service.user.UserServiceImpl;
import com.mysql.cj.x.protobuf.Mysqlx;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    private final UserService userService;

    // 회원 가입
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto dto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(dto.getUserName(), dto.getEmail(), dto.getPassword());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 로그인. email과 password가 일치할 때 seesion 키를 발급
    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequestDto dto, HttpServletRequest request) {
        LoginResponseDto responseDto = userService.login(dto.getEmail(), dto.getPassword());
        Long userId = responseDto.getUserId();

        HttpSession session = request.getSession();

        UserResponseDto loginUser = userService.findById(userId);
        session.setAttribute("LOGIN_USER", loginUser);
    }

    //로그아웃. seesion 키 삭제.
    @PostMapping("/logout")
    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }

    // id로 유저 조회
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

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestBody DeleteUserRequestDto dto) {
        userService.deleteUser(id, dto.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
