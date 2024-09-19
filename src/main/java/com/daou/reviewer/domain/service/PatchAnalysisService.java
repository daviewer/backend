package com.daou.reviewer.domain.service;

import com.daou.reviewer.domain.dto.AIUploadDiffRequest;
import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.model.AIModelFactory;
import com.daou.reviewer.model.AIModelType;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatchAnalysisService {
    final AIModelFactory aiModelFactory;
    final FileConvertManager fileConvertManager;

    // FIXME: Prompt 서비스 레이어 분리 (functional interface + score engin)
    final String prompt = "\"너는 한국인 시니어 개발자입니다. 한국어(Korean)로 대답해주세요." +
            "개발자가 제출한 풀 리퀘스트에서 변경된 다음 파일을 요약합니다.\n" +
            "파일 내의 주요 수정, 추가, 삭제 및 중요한 업데이트에 중점을 두고 요약하세요.\n" +
            "요약에 파일 이름을 포함하지 말고 글머리 기호로 요약을 나열하세요.\n" +
            "문제가 있거나 유지 관리가 까다로운 코드에 대한 조언도 해주세요.\n" +
            "요약에 코드 블록/차이점도 줄 번호와 함께 포함하세요.\"\n" +
            "그리고 마지막에 0~100점 중에 최종평가 점수를 보여주세요.\"\n" +
            "\"";

    @Transactional
    public AIUploadDiffResponse processDiffFile(MultipartFile file, AIUploadDiffRequest request) {
        log.info("request info: {}", request);
        if (file.isEmpty()) {
            return AIUploadDiffResponse.fail(400, "파일이 없습니다.");
        }
        String aiResult;
        try {
            ChatModel chatModel = aiModelFactory.choose(AIModelType.OLLAMA);
            log.info("ai model type:{}", chatModel);
            aiResult = chatModel.call(prompt + "\n" + fileConvertManager.convertFileToString(file));
        } catch (Exception e) {
            return AIUploadDiffResponse.fail(500, "오류가 발생했습니다.");
        }
        saveBranchHistory(request);
        saveAiResult(aiResult);

        return AIUploadDiffResponse.success("AI 결과 생성 및 저장에 성공했습니다.");
    }

    private void saveBranchHistory(AIUploadDiffRequest request){

    }

    private void saveAiResult(String aiResult){

    }
}
