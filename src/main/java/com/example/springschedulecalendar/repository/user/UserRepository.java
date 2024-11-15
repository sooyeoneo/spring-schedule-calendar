package com.example.springschedulecalendar.repository.user;

import com.example.springschedulecalendar.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsermail(String usermail);

    default User findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "존재하지 않는 id 입니다. "
                        )
                );
    }

    default User findByEmailOrElseThrow(String email) {
        return findByEmailOrElseThrow(email)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "존재하지 않는 email 입니다. "
                        )
                );
    }
}
