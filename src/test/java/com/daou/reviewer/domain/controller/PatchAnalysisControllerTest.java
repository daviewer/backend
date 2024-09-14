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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PatchAnalysisControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUploadDiffFile() throws Exception {
        Path filePath = Paths.get("src/test/resources/diff/diff_20240914232935.txt");
        MockMultipartFile diffFile = new MockMultipartFile(
                "diff-file",
                "sample.diff",
                "text/plain",
                Files.readAllBytes(filePath)
        );

        MockMultipartFile jsonParam = new MockMultipartFile(
                "param",
                "param.json",
                "application/json",
                "{ \"aiModelType\": \"OLLAMA\", \"additionalPrompt\": \"\" }".getBytes()
        );


        mockMvc.perform(multipart("/v1/diff-analysis/submit")
                        .file(diffFile)
                        .file(jsonParam)
                        .contentType("multipart/form-data"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}