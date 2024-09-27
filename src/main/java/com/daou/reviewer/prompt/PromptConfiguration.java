package com.daou.reviewer.prompt;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@Configuration
public class PromptConfiguration {
    public static final String PROMPT_PATH = "prompt/";
    @Value("${prompt.fileType}")
    private PromptFileType promptFileType;
    String defaultPrompt = "";

    @PostConstruct
    public void defaultPrompt() {
        defaultPrompt = promptFileToStringContent(promptFileType).orElseThrow();
    }

    protected Optional<String> promptFileToStringContent(PromptFileType promptFileType)  {
        String fileName = promptFileType.getFileName();
        ClassPathResource resource = new ClassPathResource(PROMPT_PATH + fileName);

        log.info("selected prompt file information, fileType:{}, fileName:{}", promptFileType.name(), fileName);
        try {
            return Optional.of(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8));
        }catch (IOException e) {
            log.error("failed to prompt file to string content, fileType:{}, fileName:{}", promptFileType.name(), fileName);
        }

        return Optional.empty();
    }

}