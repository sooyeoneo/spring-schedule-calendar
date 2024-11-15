package com.example.springschedulecalendar.entity.schedule;

import com.example.springschedulecalendar.entity.BaseEntity;
import com.example.springschedulecalendar.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String title;

    @Setter
    @Column(nullable = false) // columnDefinition = "longtext" 하면 Varchar보다 훨씬 긴 텍스트 저장 가능
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE, orphanRemoval = true)

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {

    }

    public Long getUserId() {
        User user = this.getUser();
        return user.getId();
    }

    public void updateSchedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
