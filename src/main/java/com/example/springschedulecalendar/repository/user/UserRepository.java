package com.example.springschedulecalendar.repository.user;

import com.example.springschedulecalendar.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
