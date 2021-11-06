package com.shop.mall.domain.login;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginForm {

    @NotEmpty(message = "아이디는 필수 입니다.")
    private String loginId;
    @NotEmpty(message = "비밀번호는 필수 입니다.")
    private String password;
}
