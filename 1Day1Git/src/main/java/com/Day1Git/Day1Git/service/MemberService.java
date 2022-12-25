package com.Day1Git.Day1Git.service;

import com.Day1Git.Day1Git.domain.Member;
import com.Day1Git.Day1Git.repository.MemberRepository;
import com.Day1Git.Day1Git.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.*;


public class MemberService {

    private MemberRepository memberRepository;


    @Autowired
   public MemberService(MemberRepository memberRepository){
      this.memberRepository = memberRepository;
    };

    public static void main(String[] args) {
        MemberService memberService = new MemberService();
    };

    /*
     회원가입
     */
    public Long join(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }
    /*
    * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}
