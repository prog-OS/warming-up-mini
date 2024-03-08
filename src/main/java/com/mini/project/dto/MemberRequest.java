package com.mini.project.dto;

import com.mini.project.domain.Role;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class MemberRequest {
    private String name;
    private String teamName;
    private Role role; // MANAGER, MEMBER
    private LocalDate birthday;
    private LocalDate workStartDate;

    public MemberRequest() {
    }

    public MemberRequest(String name, String teamName, Role role, LocalDate birthday, LocalDate workStartDate) {
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }
}
