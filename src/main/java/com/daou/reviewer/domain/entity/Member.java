package com.daou.reviewer.domain.entity;

import jakarta.persistence.*;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.entity
 * @fileName : Member
 * @date : 2024. 9. 19.
 */
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    //TODO: 필요 컬럼 정의
}
