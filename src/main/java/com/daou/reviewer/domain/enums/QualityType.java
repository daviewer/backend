package com.daou.reviewer.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QualityType {
    UNKNOWN(0, "알수없음"),
    DANGER(1, "위험"),
    CAUTION(2, "주의"),
    GOOD(3, "양호");

    private final int value;
    private final String description;
}
