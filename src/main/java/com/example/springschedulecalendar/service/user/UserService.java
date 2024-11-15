package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.LoginResDto;
import com.example.springschedulecalendar.dto.user.SignUpResDto;
import com.example.springschedulecalendar.dto.user.UserResDto;

public interface UserService {

    SignUpResDto signUp(String userName, String password, String email);

    UserResDto findById(Long id);

//    void updatePassword(Long id, String oldPassword, String newPassword);
    void deleteUser(Long id, String password);

    LoginResDto login(String email, String password);
}
