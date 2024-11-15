package com.example.springschedulecalendar.service.user;

import com.example.springschedulecalendar.dto.user.SignUpResponseDto;
import com.example.springschedulecalendar.dto.user.UserResponseDto;
import com.example.springschedulecalendar.entity.user.User;
import com.example.springschedulecalendar.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String userName, String email, String password) {

        User user = new User(userName, email, password);

        User saveUser = userRepository.save(user);

        return new SignUpResponseDto(saveUser.getId(), saveUser.getUserName(), saveUser.getEmail());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id : " + id);
        }

        User findUser = optionalUser.get();
        return new UserResponseDto(findUser.getId(), findUser.getUserName(), findUser.getEmail(), findUser.getCreatedAt(), findUser.getUpdatedAt());
    }
}
