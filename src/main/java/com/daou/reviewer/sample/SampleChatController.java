package com.daou.reviewer.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai")
public class SampleChatController {
    private final OllamaChatModel chatModel;

    @GetMapping("/generate")
    public String generate(@RequestParam String message){
        return chatModel.call(message);
    }
}
