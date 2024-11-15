package com.example.springschedulecalendar.dto.schedule;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class DeleteScheduleReqDto {
    private String password;

    @JsonCreator
    public DeleteScheduleReqDto(String password) {
        this.password = password;
    }
}
