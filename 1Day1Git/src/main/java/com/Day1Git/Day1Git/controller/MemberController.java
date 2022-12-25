package com.Day1Git.Day1Git.controller;

import com.Day1Git.Day1Git.repository.MemberRepository;
import com.Day1Git.Day1Git.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private MemberService memberService;



    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    
}