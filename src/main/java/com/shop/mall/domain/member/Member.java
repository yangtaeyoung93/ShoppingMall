package com.shop.mall.domain.member;

import com.shop.mall.domain.Address;
import com.shop.mall.domain.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


    public Member(String loginId, String name, String password, Address address) {
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public Member(Long memberId, String loginId, String name, String password, Address address) {
        this.id = memberId;
        this.loginId = loginId;
        this.name = name;
        this.password = password;
        this.address = address;
    }
}
