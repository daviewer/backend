package com.daou.reviewer.model;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class AIModelFactory {

    Map<AIModelType, ChatModel> aiModelEngineMap;

    @Autowired
    public AIModelFactory(List<AIChatModel> aiModels) {
        aiModelEngineMap = aiModels.stream().collect(Collectors.toMap(AIChatModel::getType, AIChatModel::getModel));
    }

    public ChatModel choose(AIModelType aiModelType) {
        return aiModelEngineMap.get(aiModelType);
    }

}
