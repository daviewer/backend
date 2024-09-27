package com.daou.reviewer.prompt;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PromptTemplateManager {
    final PromptConfiguration promptConfiguration;

    public String getUserMessage(PromptFileType promptFileType, List<PromptTemplateParameter> parameters){
        String prompt = promptConfiguration.promptFileToStringContent(promptFileType).orElseThrow();
        return buildTemplate(prompt, parameters).render();
    }
    public String getUserMessage(List<PromptTemplateParameter> parameters){
        String prompt = promptConfiguration.defaultPrompt;
        return buildTemplate(prompt, parameters).render();
    }


    public PromptTemplate buildTemplate(String prompt, List<PromptTemplateParameter> parameters) {
        PromptTemplate promptTemplate = new PromptTemplate(prompt);

        parameters.forEach( p -> {
            promptTemplate.add(p.key(), p.value());
        });

        return promptTemplate;
    }
}
