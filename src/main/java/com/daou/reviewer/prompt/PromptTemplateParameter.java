package com.daou.reviewer.prompt;


public record PromptTemplateParameter(
        String key, String value
) {

    public static PromptTemplateParameter of(String key, String value){
        return new PromptTemplateParameter(key, value);
    }
}
