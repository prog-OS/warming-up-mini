package com.mini.project.controller;

import com.mini.project.dto.MemberRequest;
import com.mini.project.dto.TeamRequest;
import com.mini.project.dto.TeamResponse;
import com.mini.project.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team")
    public void createTeam(@RequestBody TeamRequest request) {
        teamService.saveTeam(request);
    }

    @GetMapping("/team")
    public List<TeamResponse> findAllTeam() {
        return teamService.findAllTeam();
    }
}

