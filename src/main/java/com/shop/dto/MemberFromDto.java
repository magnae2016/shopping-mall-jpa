package com.shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberFromDto {

    private String name;

    private String email;

    private String password;

    private String address;
}

