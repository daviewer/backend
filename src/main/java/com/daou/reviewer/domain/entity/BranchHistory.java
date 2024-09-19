package com.daou.reviewer.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author : kingmj
 * @description :
 * @packageName : com.daou.reviewer.domain.entity
 * @fileName : BranchHistory
 * @date : 2024. 9. 19.
 */
@Entity
public class BranchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private String originalBranch;

    @Column(nullable = false)
    private String comparisonBranch;

    private LocalDateTime insertDate;
}
