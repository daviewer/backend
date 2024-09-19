package com.daou.reviewer.domain.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.entity
 * @fileName : Member
 * @date : 2024. 9. 19.
 */
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    //TODO: 필요 컬럼 정의

    @Builder
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
