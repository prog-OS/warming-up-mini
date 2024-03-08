package com.mini.project.service;

import com.mini.project.domain.Member;
import com.mini.project.domain.Role;
import com.mini.project.domain.Team;
import com.mini.project.dto.MemberRequest;
import com.mini.project.dto.MemberResponse;
import com.mini.project.repository.MemberRepository;
import com.mini.project.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void saveMember(MemberRequest request) {

        Team team = teamRepository.findByName(request.getTeamName()).orElseThrow(IllegalArgumentException::new);

        if (request.getRole() == Role.MANAGER) {
            team.updateManager(request.getName());
        }

        Member member = new Member(
                request.getName(),
                team,
                request.getRole(),
                request.getBirthday(),
                request.getWorkStartDate()
        );

        memberRepository.save(member);
    }

    @Transactional
    public List<MemberResponse> findAllMember() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream()
                .map(m -> MemberResponse.builder()
                        .name(m.getName())
                        .teamName(m.getTeam().getName())
                        .role(m.getRole())
                        .birthday(m.getBirthday())
                        .workStartDate(m.getWorkStartDate())
                        .build())
                .toList();
    }
}
