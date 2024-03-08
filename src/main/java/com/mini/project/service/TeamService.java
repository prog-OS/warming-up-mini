package com.mini.project.service;

import com.mini.project.domain.Team;
import com.mini.project.dto.TeamRequest;
import com.mini.project.dto.TeamResponse;
import com.mini.project.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void saveTeam(TeamRequest request) {
        Team team = new Team(request.getTeamName());
        teamRepository.save(team);
    }

    public List<TeamResponse> findAllTeam() {
        List<Team> teamList = teamRepository.findAll();
        return teamList.stream()
                .map(t -> TeamResponse.builder()
                        .name(t.getName())
                        .manager(t.getManager())
                        .memberCount(t.getMemberCount())
                        .build())
                .toList();
    }
}
