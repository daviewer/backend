package com.daou.reviewer.model;

import org.springframework.ai.chat.model.ChatModel;

public interface AIChatModel {
    AIModelType getType();
    ChatModel getModel();
}
