package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
import java.util.HashMap;
import java.util.Map;

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

        Map<String, Object> expectedResponse = new HashMap<>();
        expectedResponse.put("date", LocalDate.now().toString());
        expectedResponse.put("status", "OK");
        expectedResponse.put("message", "Transfer was successfully performed");
        expectedResponse.put("transaction", dto);

        ResponseEntity<String> response = client.postForEntity(getUri() +"/api/accounts/transfer", dto, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        String json = response.getBody();
        assertNotNull(json);
        assertTrue(json.contains("\"message\":\"Transfer was successfully performed\""));
        assertTrue(json.contains("\"transaction\":" + objectMapper.writeValueAsString(dto)));
        assertTrue(json.contains("\"date\":\"" + LocalDate.now().toString() + "\""));

        // converting string to a json object, better way to navigate into json structure
        JsonNode jsonNode = objectMapper.readTree(json);

        assertEquals("Transfer was successfully performed", jsonNode.path("message").asText());
        assertEquals(LocalDate.now().toString(), jsonNode.path("date").asText());

        assertEquals(dto.getOriginAccountId(), jsonNode.path("transaction").path("originAccountId").asLong());
        assertEquals(dto.getDestinationAccountId(), jsonNode.path("transaction").path("destinationAccountId").asLong());
        assertEquals(dto.getBankId(), jsonNode.path("transaction").path("bankId").asLong());
        assertEquals(dto.getAmount().toPlainString(), jsonNode.path("transaction").path("amount").asText());

        assertEquals(objectMapper.writeValueAsString(expectedResponse), json);
        System.out.println(json);
    }
}