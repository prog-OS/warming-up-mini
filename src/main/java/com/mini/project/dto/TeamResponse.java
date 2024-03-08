package com.mini.project.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamResponse {
    private String name;
    private String manager;
    private int memberCount;

    @Builder
    public TeamResponse(String name, String manager, int memberCount) {
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }
}
