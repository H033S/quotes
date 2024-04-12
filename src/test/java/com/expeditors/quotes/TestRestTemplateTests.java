package com.expeditors.quotes;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRestTemplateTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private QuotesService quotesService;

    @Test
    public void quotesEndpointShouldReturn3Quotes () {

        Mockito.doReturn(List.of("1", "2"))
                .when(quotesService).getAllQuotes();

        var results = testRestTemplate
                .getForObject(
                "/api/quotes",
                List.class);

        assertEquals(2, results.size());
    }
}
