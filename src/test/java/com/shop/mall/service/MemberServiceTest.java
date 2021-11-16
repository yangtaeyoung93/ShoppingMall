package com.shop.mall.service;

import com.shop.mall.domain.member.Member;
import com.shop.mall.repository.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;

    @Test
    public void 회원가입() throws Exception{
        //Given
        Member member = new Member();
        member.setName("yang");

        //WHen
        Long saveId = memberService.join(member);


        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외(){
        //given
        Member member = new Member();
        member.setName("Yang");

        Member member1 = new Member();
        member1.setName("Yang");

        //when
        memberService.join(member);
        memberService.join(member1);

        //then
        fail("에외가 발생해야 한다");
    }


    @Test
    public void 비번암호화테스트(){
        //given
        String rawpwd = "xptmxm23";
        //when
        String encodedpwd = passwordEncoder.encode(rawpwd);
        //then
        assertNotEquals(rawpwd,encodedpwd);
        assertTrue(passwordEncoder.matches(rawpwd,encodedpwd));
    }

}