package com.daou.reviewer.domain.service;

import com.daou.reviewer.domain.dto.AIUploadDiffRequest;
import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.model.AIModelFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class PatchAnalysisService {
    final AIModelFactory aiModelFactory;
    final FileConvertManager fileConvertManager;

    public AIUploadDiffResponse processDiffFile(MultipartFile file, AIUploadDiffRequest request) {
        String aiResult = aiModelFactory.choose(request.aiModelType()).getModel().call(fileConvertManager.convertFileToString(file));

        return AIUploadDiffResponse.success(aiResult);
    }
}
