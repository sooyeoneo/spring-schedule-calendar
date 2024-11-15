package com.example.springschedulecalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringScheduleCalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScheduleCalendarApplication.class, args);
    }

}
