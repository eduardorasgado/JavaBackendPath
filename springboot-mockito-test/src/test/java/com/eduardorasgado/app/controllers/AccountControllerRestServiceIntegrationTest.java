package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

// webEnvironment WebEnvironment.RANDOM_PORT creates a real server to test endpoints
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerRestServiceIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Value("${testing.integration.rest-client.url}")
    private String serviceUrl;

    @Test
    void testTransfer() throws JsonProcessingException {
        // Given
        TransactionRequestDto dto = new TransactionRequestDto();
        dto.setOriginAccountId(1L);
        dto.setDestinationAccountId(2L);
        dto.setBankId(1L);
        dto.setAmount(new BigDecimal(300));

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "OK");
        response.put("message", "Transfer was successfully performed");
        response.put("transaction", dto);

        // When
        webClient.post().uri(serviceUrl + "/api/accounts/transfer")
        // we can also do the next thing because our tests are on the same project than the spring boot project to test
        // but when we have microservices or independent services separated from our testing suite it is important to refer
        // to the full url path with port
        //webClient.post().uri("/api/accounts/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                // we don't need to map dto object using object mapper because web test client does it for us
                .bodyValue(dto)
                .exchange()

                .expectStatus()
                    .isOk()
                .expectBody()
                    .jsonPath("$.message").isNotEmpty()
                .jsonPath("$.message").value(Matchers.is("Transfer was successfully performed"))
                .jsonPath("$.message").value(value -> assertEquals(value, "Transfer was successfully performed"))
                .jsonPath("$.message").isEqualTo("Transfer was successfully performed")
                .jsonPath("$.transaction.originAccountId").isEqualTo(dto.getOriginAccountId())
                .jsonPath("$.transaction.destinationAccountId").isEqualTo(dto.getDestinationAccountId())
                .jsonPath("$.date").isEqualTo(LocalDate.now().toString())

                .json(objectMapper.writeValueAsString(response));

    }
}