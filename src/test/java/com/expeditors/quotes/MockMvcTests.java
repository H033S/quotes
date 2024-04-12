package com.expeditors.quotes;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void quotesEndpointShouldReturn3Quotes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/quotes"))

                .andExpect(MockMvcResultMatchers
                        .status()
                        .isOk())

                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.length()")
                        .value(3));

    }
}
