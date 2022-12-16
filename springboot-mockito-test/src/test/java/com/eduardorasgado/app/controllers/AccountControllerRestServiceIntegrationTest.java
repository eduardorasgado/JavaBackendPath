package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// webEnvironment WebEnvironment.RANDOM_PORT creates a real server to test endpoints
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerRestServiceIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Value("${testing.integration.rest-client.url}")
    private String serviceUrl;

    @Test
    void testTransfer() {
        // Given
        TransactionRequestDto dto = new TransactionRequestDto();
        dto.setOriginAccountId(1L);
        dto.setDestinationAccountId(2L);
        dto.setBankId(1L);
        dto.setAmount(new BigDecimal(300));

        // When
        webClient.post().uri(serviceUrl + "/api/accounts/transfer")
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
                .jsonPath("$.date").isEqualTo(LocalDate.now().toString());

    }
}