package com.daou.reviewer.model;

import org.springframework.ai.chat.model.ChatModel;

public interface AIModelEngine {
    AIModelType getType();
    ChatModel getModel();
}
