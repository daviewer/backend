package com.daou.reviewer.domain.service;

import com.daou.reviewer.domain.dto.AIUploadDiffRequest;
import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.model.AIModelFactory;
import com.daou.reviewer.model.AIModelType;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class PatchAnalysisService {
    final AIModelFactory aiModelFactory;
    final FileConvertManager fileConvertManager;

    // FIXME: Prompt 서비스 레이어 분리 (functional interface + score engin)
    final String prompt = "String message = \"\n" +
            "\"너는 한국인 시니어 개발자다. 한국어(Korean)로 대답해줘\n" +
            "개발자가 제출한 풀 리퀘스트에서 변경된 다음 파일을 요약합니다.\n" +
            "파일 내의 주요 수정, 추가, 삭제 및 중요한 업데이트에 중점을 두고 요약하세요.\n" +
            "요약에 파일 이름을 포함하지 말고 글머리 기호로 요약을 나열하세요.\n" +
            "문제가 있거나 유지 관리가 까다로운 코드에 대한 조언도 해주세요.\n" +
            "요약에 코드 블록/차이점도 줄 번호와 함께 포함하세요.\"\n" +
            "\"";

    public AIUploadDiffResponse processDiffFile(MultipartFile file, AIUploadDiffRequest request) {
        ChatModel chatModel = aiModelFactory.choose(AIModelType.OLLAMA);
        String aiResult = chatModel.call(
                prompt + "\n" + fileConvertManager.convertFileToString(file)
        );

        return AIUploadDiffResponse.success(aiResult);
    }
}
