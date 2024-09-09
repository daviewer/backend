package com.daou.reviewer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewerApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testChatAI() throws Exception {
        String message = "호날두 vs 메시 누가 더 위대한 인물인가?";
        MvcResult mvcResult = mockMvc.perform(get("/api/v1/ai/generate").param("message", message))
                                     .andExpect(status().isOk())
                                     .andReturn();

        String responseBody = mvcResult.getResponse()
									   .getContentAsString();
        System.out.println("응답 결과: " + responseBody);

    }

}
