package com.shop.entity;

import com.shop.constant.Role;
import com.shop.dto.MemberFromDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember(MemberFromDto memberFromDto,
                                      PasswordEncoder passwordEncoder) {
        String password = passwordEncoder.encode(memberFromDto.getPassword());
        Member member = Member.builder()
                .name(memberFromDto.getName())
                .email(memberFromDto.getEmail())
                .address(memberFromDto.getAddress())
                .password(password)
                .role(Role.USER)
                .build();
        return member;
    }
}
