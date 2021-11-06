package com.shop.mall.web.member;

import com.shop.mall.domain.Address;
import com.shop.mall.domain.member.Member;
import com.shop.mall.domain.member.MemberForm;
import com.shop.mall.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@Slf4j
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(Model model)
    {
        model.addAttribute("memberForm", new MemberForm());
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String create(@Validated MemberForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());

        Member member = new Member(form.getLoginId(),form.getName(),form.getPassword(),address);
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("")
    public String members (Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
