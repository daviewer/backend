package com.daou.reviewer.domain.dto;

import com.daou.reviewer.model.AIModelType;

public record AIUploadDiffRequest(
        AIModelType aiModelType,
        String additionalPrompt // 추가 요청사항
) {
}
