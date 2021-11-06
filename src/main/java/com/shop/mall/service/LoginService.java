package com.shop.mall.service;

import com.shop.mall.domain.member.Member;
import com.shop.mall.domain.member.MemberForm;
import com.shop.mall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     *
     * @param loginId
     * @param password
     * @return null이면 로그인 실패
     */
    public Member login(String loginId, String password){
        log.info("loginId ={}, password={}",loginId,password);
       return  memberRepository.findById(loginId)
               .stream().filter(m -> m.getPassword().equals(password)).findFirst().orElse(null);
    }
}
