package com.daou.reviewer.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
public class BranchHistory {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @NotNull
    private String sourceBranch;
    @NotNull
    private String targetBranch;
    @NotNull
    private LocalDateTime createdDate;
}
