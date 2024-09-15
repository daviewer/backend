package com.daou.reviewer.domain.controller;

import com.daou.reviewer.domain.dto.AIUploadDiffRequest;
import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.domain.dto.ApiResponse;
import com.daou.reviewer.domain.service.PatchAnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
public class PatchAnalysisController {

    final PatchAnalysisService patchAnalysisService;

    @PostMapping("/diff-analysis/submit")
    public ApiResponse<String> uploadDiffFile(
            @RequestPart("diff-file") MultipartFile file,
            @RequestPart("param") AIUploadDiffRequest parameter) {

        log.info("request info: {}", parameter);

        if (file.isEmpty()) {
            return new AIUploadDiffResponse<>(400, "파일이 없습니다.", null);
        }

        try {
            return patchAnalysisService.processDiffFile(file, parameter);
        } catch (Exception e) {
            return new AIUploadDiffResponse<>(500, "오류가 발생했습니다.", null);
        }
    }

}
