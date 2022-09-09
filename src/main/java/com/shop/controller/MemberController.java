package com.shop.controller;

import com.shop.dto.MemberFromDto;
import com.shop.entity.Member;
import com.shop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFromDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(MemberFromDto memberFromDto) {
        Member member = Member.createMember(memberFromDto, passwordEncoder);
        memberService.saveMember(member);

        return "redirect:/";
    }
}
