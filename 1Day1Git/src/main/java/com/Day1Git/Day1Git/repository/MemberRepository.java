package com.Day1Git.Day1Git.repository;

import com.Day1Git.Day1Git.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member meber);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
