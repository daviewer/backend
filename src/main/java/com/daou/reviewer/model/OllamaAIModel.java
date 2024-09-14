package com.daou.reviewer.model;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OllamaAIModel implements AIModelEngine {

    private final OllamaChatModel ollamaChatModel;
    @Override
    public AIModelType getType() {
        return AIModelType.OLLAMA;
    }

    @Override
    public ChatModel getModel() {
        return ollamaChatModel;
    }
}
