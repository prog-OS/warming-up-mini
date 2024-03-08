package com.mini.project.controller;

import com.mini.project.dto.MemberRequest;
import com.mini.project.dto.MemberResponse;
import com.mini.project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void createMember(@RequestBody MemberRequest request) {
        memberService.saveMember(request);
    }

    @GetMapping("/member")
    public List<MemberResponse> findAllMember() {
        return memberService.findAllMember();
    }

}
