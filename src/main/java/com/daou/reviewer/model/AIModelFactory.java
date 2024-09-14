package com.daou.reviewer.model;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class AIModelFactory {

    Map<AIModelType, AIModelEngine> aiModelEngineMap = new HashMap<>();

    public AIModelFactory(List<AIModelEngine> aiModels) {
        aiModels.stream().collect(Collectors.toMap(AIModelEngine::getType, AIModelEngine::getModel));
    }

    public AIModelEngine choose(AIModelType aiModelType) {
        return aiModelEngineMap.get(aiModelType);
    }

}
