package com.daou.reviewer.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.entity
 * @fileName : ChatHistory
 * @date : 2024. 9. 19.
 */
@Getter
@Entity
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 30000)
    private String result;

    private LocalDateTime completeDate;
}
