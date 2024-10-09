package com.daou.reviewer.domain.entity;

import com.daou.reviewer.domain.enums.QuantityType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
public class ChatResultHistory {
    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "branchHistoryId")
    private BranchHistory branchHistory;
    @NotNull
    private String title;
    @NotNull
    private String keyChanges;
    @NotNull
    private String keyImprovements;
    @NotNull
    @ColumnDefault("0")
    @Enumerated(EnumType.ORDINAL)
    private QuantityType quantity;
    @NotNull
    @ColumnDefault("1")
    private Boolean status;
    @NotNull
    private LocalDateTime createdDate;
}
