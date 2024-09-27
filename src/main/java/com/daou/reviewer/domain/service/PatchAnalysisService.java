package com.daou.reviewer.domain.service;

import com.daou.reviewer.domain.dto.AIUploadDiffRequest;
import com.daou.reviewer.domain.dto.AIUploadDiffResponse;
import com.daou.reviewer.model.AIModelFactory;
import com.daou.reviewer.model.AIModelType;
import com.daou.reviewer.prompt.PromptTemplateManager;
import com.daou.reviewer.prompt.PromptTemplateParameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
@Service
public class PatchAnalysisService {
    final AIModelFactory aiModelFactory;
    final FileConvertManager fileConvertManager;
    final PromptTemplateManager promptTemplateManager;

    public AIUploadDiffResponse processDiffFile(MultipartFile file, AIUploadDiffRequest request) {
        ChatModel chatModel = aiModelFactory.choose(AIModelType.OLLAMA);
        log.info("ai model type:{}", chatModel);
        String fileContent = fileConvertManager.convertFileToString(file);

        PromptTemplateParameter diffBody = PromptTemplateParameter.of("diffBody", fileContent);
        Message userMessage = new UserMessage(promptTemplateManager.getUserMessage(Collections.singletonList(diffBody)));
//        Message systemMessage = new SystemMessage("너는 한국인 시니어 개발자이다. 한국어로 대답해줘야한다"); // TODO message 를 2개 이상 호출하면 하나만 먹히는 것 같은..?
//        String result = chatModel.call(systemMessage, userMessage);

        String result = chatModel.call(userMessage);

        return AIUploadDiffResponse.success(result);
    }
}
