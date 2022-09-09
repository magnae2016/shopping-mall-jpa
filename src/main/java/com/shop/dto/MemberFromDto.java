package com.shop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberFromDto {

    private String name;

    private String email;

    private String password;

    private String address;
}

