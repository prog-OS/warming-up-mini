package com.mini.project.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    private String manager; // 없을 경우 null

    @OneToMany(mappedBy = "team")
    List<Member> memberList = new ArrayList<>();

    @Column(nullable = false)
    private int memberCount; // 팀 인원 수

    public Team(String teamName) {
        this.name = teamName;
        this.memberCount = 0;
    }

    public Team() {
    }

    public void updateManager(String manager) {
        this.manager = manager;
    }

    public int getMemberCount() {
        return memberList.size();
    }
}
