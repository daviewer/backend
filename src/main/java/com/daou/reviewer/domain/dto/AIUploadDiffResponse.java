package com.daou.reviewer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class AIUploadDiffResponse<T> implements ApiResponse<T> {
    private final int code;
    private final String message;
    private final T body;

    public static AIUploadDiffResponse success(String result) {
        return AIUploadDiffResponse.builder()
                .code(200)
                .message("success")
                .body(result)
                .build();
    }

    public static AIUploadDiffResponse fail(int code, String message) {
        return AIUploadDiffResponse.builder()
                .code(code)
                .message(message)
                .body(null)
                .build();
    }
}