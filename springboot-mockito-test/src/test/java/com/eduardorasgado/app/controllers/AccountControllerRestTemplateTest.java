package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    private String getUri() {
        return "http://localhost:" + port;
    }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @Order(1)
    void testTransfer() throws JsonProcessingException {
        TransactionRequestDto dto = new TransactionRequestDto();

        dto.setAmount(new BigDecimal("700"));
        dto.setOriginAccountId(2L);
        dto.setDestinationAccountId(1L);
        dto.setBankId(1L);

        ResponseEntity<String> response = client.postForEntity(getUri() +"/api/accounts/transfer", dto, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        String json = response.getBody();
        assertNotNull(json);
        assertTrue(json.contains("\"message\":\"Transfer was successfully performed\""));
        assertTrue(json.contains("\"transaction\":" + objectMapper.writeValueAsString(dto)));
        assertTrue(json.contains("\"date\":\"" + LocalDate.now().toString() + "\""));

        System.out.println(json);
    }
}