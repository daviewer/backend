package com.daou.reviewer.domain.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PatchAnalysisControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUploadDiffFile() throws Exception {
        Path filePath = Paths.get("src/test/resources/test/sample.diff");
        MockMultipartFile diffFile = new MockMultipartFile(
                "diff-file",
                "sample.diff",
                "text/plain",
                Files.readAllBytes(filePath)
        );

        String jsonRequest = "{ \"aiModelType\": \"OLLAMA\", \"additionalPrompt\": \"\" }";

        mockMvc.perform(multipart("/v1/ai/upload-diff")
                        .file(diffFile)                        // diff 파일 추가
                        .param("param", jsonRequest)         // JSON 요청 추가
                        .contentType("multipart/form-data"))
                .andExpect(status().isOk());                   // 기대하는 응답 상태 코드
    }
}