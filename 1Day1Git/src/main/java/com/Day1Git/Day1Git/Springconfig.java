package com.Day1Git.Day1Git;

import com.Day1Git.Day1Git.repository.JdbcMemberRepository;
import com.Day1Git.Day1Git.repository.JdbcTemplateMemberRepository;
import com.Day1Git.Day1Git.repository.MemberRepository;
import com.Day1Git.Day1Git.repository.MemoryMemberRepository;
import com.Day1Git.Day1Git.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Springconfig {

    private final DataSource dataSource;
      public SpringConfig(DataSource dataSource) {
          this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
      public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
      }
 
}
