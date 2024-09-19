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
    public ApiResponse<Void> uploadDiffFile(@RequestPart("diff-file") MultipartFile file, @RequestPart("param") AIUploadDiffRequest parameter) {
        return patchAnalysisService.processDiffFile(file, parameter);
    }

}
