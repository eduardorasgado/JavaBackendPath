package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.AccountTestData;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.AccountResponseDto;
import com.eduardorasgado.app.payloads.mappers.accounts.response.AccountResponseDtoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

// webEnvironment WebEnvironment.RANDOM_PORT creates a real server to test endpoints
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
    @Order(3)
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
        //webClient.post().uri(serviceUrl + "/api/accounts/transfer")
        // we can also do the next thing because our tests are on the same project than the spring boot project to test
        // but when we have microservices or independent services separated from our testing suite it is important to refer
        // the full url path with port and start the service on that url and port
        webClient.post().uri("/api/accounts/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                // we don't need to map dto object using object mapper because web test client does it for us
                .bodyValue(dto)
                .exchange()

                // Then
                .expectStatus()
                    .isOk()
                .expectHeader()
                    .contentType(MediaType.APPLICATION_JSON)
                // by defining the class expected from response body we could consume it directly
                // as that class type
                //.expectBody(String.class)
                // receiving object as byte type
                .expectBody()
                // evaluating the response by using a consumer lambda
                .consumeWith(res -> {
                    try {
                        JsonNode json = objectMapper.readTree(res.getResponseBody());

                        assertEquals("Transfer was successfully performed", json.path("message").asText());
                        assertEquals(1L, json.path("transaction")
                                .path("originAccountId").asLong());
                        assertEquals(2L, json.path("transaction")
                                .path("destinationAccountId").asLong());
                        assertEquals(1L, json.path("transaction")
                                .path("bankId").asLong());
                        assertEquals("300", json.path("transaction")
                                .path("amount").asText());
                        assertEquals(LocalDate.now().toString(), json.path("date").asText());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                // the jsonPath way to evaluate response object
                //.expectBody()
                .jsonPath("$.message").isNotEmpty()
                .jsonPath("$.message").value(Matchers.is("Transfer was successfully performed"))
                .jsonPath("$.message").value(value -> assertEquals(value, "Transfer was successfully performed"))
                .jsonPath("$.message").isEqualTo("Transfer was successfully performed")
                .jsonPath("$.transaction.originAccountId").isEqualTo(dto.getOriginAccountId())
                .jsonPath("$.transaction.destinationAccountId").isEqualTo(dto.getDestinationAccountId())
                .jsonPath("$.date").isEqualTo(LocalDate.now().toString())

                .json(objectMapper.writeValueAsString(response));
    }

    @Test
    @Order(1)
    void testDetailAccount1() throws JsonProcessingException {
        Account accountToFetch = AccountTestData.getNewAccount001().orElseThrow();

        webClient.get().uri("/api/accounts/" + accountToFetch.getId())
                .exchange()
                .expectStatus()
                    .isOk()
                .expectHeader()
                    .contentType(MediaType.APPLICATION_JSON)

                .expectBody()
                .jsonPath("$.id").isEqualTo(accountToFetch.getId())
                .jsonPath("$.name").isEqualTo(accountToFetch.getName())
                .jsonPath("$.balance").isEqualTo(accountToFetch.getBalance().doubleValue())
                .json(objectMapper.writeValueAsString(
                        AccountResponseDtoMapper.mapModelToDto(accountToFetch, new AccountResponseDto())
                ));
    }

    @Test
    @Order(2)
    void testDetailAccount2() {
        Account accountToFetch = AccountTestData.getNewAccount002().orElseThrow();

        webClient.get().uri("/api/accounts/" + accountToFetch.getId())
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBody(AccountResponseDto.class)
                .consumeWith(response -> {
                    AccountResponseDto accountDto = response.getResponseBody();

                    assertNotNull(accountDto);
                    assertEquals(accountToFetch.getId(), accountDto.getId());
                    assertEquals(accountToFetch.getName(), accountDto.getName());
                    assertEquals(0, accountToFetch.getBalance().compareTo(accountDto.getBalance()));
                });
    }
}