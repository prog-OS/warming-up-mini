package com.mini.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role; // MANAGER, MEMBER

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private LocalDate workStartDate;

    public Member(String name,
                  Team team,
                  Role role,
                  LocalDate birthday,
                  LocalDate workStartDate) {
        this.name = name;
        this.team = team;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public Member() {
    }
}
