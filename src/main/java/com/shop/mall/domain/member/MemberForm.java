package com.shop.mall.domain.member;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;
    @NotEmpty(message = "아이디는 필수 입니다.")
    private String loginId;
    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Length(min = 8,max = 12,message = "비밀번호는 8자 이상 12자 이하 입니다.")
    private String password;

    private String city;
    private String street;
    private String zipcode;
}
