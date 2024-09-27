package com.daou.reviewer.prompt;

import lombok.Getter;

@Getter
public enum PromptFileType {
    REVIEW_R001("R001"),
    PROMPT_A001("prompt_A001"); // 다른 프롬프트 추가

    private final String fileName;

    PromptFileType(String fileName) {
        this.fileName = fileName;
    }
}
