package com.example.springschedulecalendar.entity.schedule;

import com.example.springschedulecalendar.entity.BaseEntity;
import com.example.springschedulecalendar.entity.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    @Id
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

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.REMOVE, orphanRemoval = true)

    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public Schedule() {

    }
}
