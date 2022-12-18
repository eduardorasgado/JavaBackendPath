package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.AccountTestData;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.request.AccountToSaveRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.AccountResponseDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.SavedAccountResponseDto;
import com.eduardorasgado.app.payloads.mappers.accounts.request.AccountToSaveRequestDtoMapper;
import com.eduardorasgado.app.payloads.mappers.accounts.response.AccountResponseDtoMapper;
import com.eduardorasgado.app.payloads.mappers.accounts.response.ListAllAccountsResponseDtoMapper;
import com.eduardorasgado.app.payloads.mappers.accounts.response.SavedAccountResponseDtoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
    REST SERVICES INTEGRATION TESTS USING TestRestTemplate
 */

@Tag("REST_TEMPLATE_INTEGRATION_TEST")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerRestTemplateIntegrationTest {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int port;

    private String getUri(String path) {
        return "http://localhost:" + port + path;
    }

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    @Order(3)
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

        // dto is passed as an application json content type by default
        ResponseEntity<String> response = client.postForEntity(getUri("/api/accounts/transfer"), dto, String.class);

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

    @Test
    @Order(1)
    void testDetail() {
        long idToGet = 1L;
        ResponseEntity<AccountResponseDto> actualResponse = client.getForEntity(
                getUri("/api/accounts/" + idToGet), AccountResponseDto.class
        );

        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, actualResponse.getHeaders().getContentType());


        AccountResponseDto accountDto = actualResponse.getBody();
        assertNotNull(accountDto);

        AccountResponseDto expectedResponseDto = AccountResponseDtoMapper.mapModelToDto(
                AccountTestData.getNewAccount001().orElseThrow(), new AccountResponseDto()
        );

        assertEquals(expectedResponseDto.getId(), accountDto.getId());
        assertEquals(expectedResponseDto.getName(), accountDto.getName());
        assertEquals(0, accountDto.getBalance().compareTo(expectedResponseDto.getBalance()));

        assertEquals(expectedResponseDto, accountDto);
    }

    @Test
    @Order(2)
    void testListAll() throws JsonProcessingException {
        // Given
        ListAllAccountsResponseDto expectedResponseDto = ListAllAccountsResponseDtoMapper.mapModelToDto(Arrays.asList(
                AccountTestData.getNewAccount001().orElseThrow(),
                AccountTestData.getNewAccount002().orElseThrow()
        ), new ListAllAccountsResponseDto());

        // When
        ResponseEntity<ListAllAccountsResponseDto> actualResponse = client.getForEntity(
                getUri("/api/accounts"), ListAllAccountsResponseDto.class
        );

        // Then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, actualResponse.getHeaders().getContentType());

        ListAllAccountsResponseDto actualResponseDto = actualResponse.getBody();
        assertNotNull(actualResponseDto);

        List<ListAllAccountsResponseDto.AccountResponseDto> actualResponseDtoList = actualResponseDto.getAccounts();
        List<ListAllAccountsResponseDto.AccountResponseDto> expectedResponseDtoList = expectedResponseDto.getAccounts();

        assertEquals(2, actualResponseDtoList.size());

        assertEquals(expectedResponseDtoList.get(0).getId(), actualResponseDtoList.get(0).getId());
        assertEquals(expectedResponseDtoList.get(0).getName(), actualResponseDtoList.get(0).getName());
        assertEquals(0, expectedResponseDtoList.get(0).getBalance().compareTo(actualResponseDtoList.get(0).getBalance()));

        assertEquals(expectedResponseDtoList.get(1).getId(), actualResponseDtoList.get(1).getId());
        assertEquals(expectedResponseDtoList.get(1).getName(), actualResponseDtoList.get(1).getName());
        assertEquals(0, expectedResponseDtoList.get(1).getBalance().compareTo(actualResponseDtoList.get(1).getBalance()));

        assertEquals(expectedResponseDto, actualResponseDto);

        JsonNode json = objectMapper.readTree(objectMapper.writeValueAsString(actualResponse.getBody()));

        JsonNode account1 = json.path("accounts").get(0);
        ListAllAccountsResponseDto.AccountResponseDto expectedAccountDto1 = expectedResponseDtoList.get(0);

        assertEquals(
                expectedAccountDto1.getId(),
                account1.path("id").asLong()
        );
        assertEquals(
                expectedAccountDto1.getName(),
                account1.path("name").asText()
        );
        assertEquals(
                0,
                expectedAccountDto1.getBalance().compareTo(
                        new BigDecimal(account1.path("balance").asText())
                )
        );

        JsonNode account2 = json.path("accounts").get(1);
        ListAllAccountsResponseDto.AccountResponseDto expectedAccountDto2 = expectedResponseDtoList.get(1);

        assertEquals(
                expectedAccountDto2.getId(),
                account2.path("id").asLong()
        );
        assertEquals(
                expectedAccountDto2.getName(),
                account2.path("name").asText()
        );
        assertEquals(
                0,
                expectedAccountDto2.getBalance().compareTo(
                        new BigDecimal(account2.path("balance").asText())
                )
        );
    }

    @Test
    @Order(3)
    void testSave() {
        AccountToSaveRequestDto accountToSaveDto = AccountToSaveRequestDtoMapper.mapModelToDto(
                AccountTestData.dummyAccount1, new AccountToSaveRequestDto()
        );

        ResponseEntity<SavedAccountResponseDto> response = client.postForEntity(
                getUri("/api/accounts/"), accountToSaveDto, SavedAccountResponseDto.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());

        SavedAccountResponseDto actualSavedAccountDto = response.getBody();
        assertNotNull(actualSavedAccountDto);
        assertNotNull(actualSavedAccountDto.getMessage());
        assertNotNull(actualSavedAccountDto.getAccount());

        Account expectedSavedAccount = AccountTestData.dummyAccount1.clone();
        expectedSavedAccount.setId(3L);
        SavedAccountResponseDto expectedSavedAccountDto = new SavedAccountResponseDto();
        expectedSavedAccountDto.setMessage("Account successfully created");
        SavedAccountResponseDtoMapper.mapModelToDto(expectedSavedAccount, expectedSavedAccountDto);

        assertEquals(expectedSavedAccountDto.getMessage(), actualSavedAccountDto.getMessage());

        SavedAccountResponseDto.AccountResponseDto expectedAccountDto = expectedSavedAccountDto.getAccount();
        SavedAccountResponseDto.AccountResponseDto actualAccountDto = actualSavedAccountDto.getAccount();

        assertEquals(expectedAccountDto.getId(), actualAccountDto.getId());
        assertEquals(expectedAccountDto.getName(), actualAccountDto.getName());
        assertEquals(0, expectedAccountDto.getBalance().compareTo(actualAccountDto.getBalance()));
    }

    @Test
    @Order(4)
    void testDelete() {
        Long idToDelete = 2L;
        ResponseEntity<ListAllAccountsResponseDto> actualResponse = client.getForEntity(
                getUri("/api/accounts"), ListAllAccountsResponseDto.class
        );
        ListAllAccountsResponseDto listAllResponse = actualResponse.getBody();
        assertNotNull(listAllResponse);
        assertNotNull(listAllResponse.getAccounts());
        assertTrue(listAllResponse.getAccounts().stream().anyMatch(account -> account.getId() == idToDelete));

        //client.delete(getUri("/api/accounts/" +idToDelete));
        //ResponseEntity<Void> deleteResponse = client.exchange(getUri("/api/accounts/2"), HttpMethod.DELETE, null, Void.class);
        ResponseEntity<Void> deleteResponse = client.exchange(
                getUri("/api/accounts/{id}"), HttpMethod.DELETE, null, Void.class, new HashMap<>() {
            {
                // same path variable name as in controller's delete method
                put("id", 2L);
            }
        });

        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
        assertFalse(deleteResponse.hasBody());

        ResponseEntity<AccountResponseDto> getDetailResponse = client.getForEntity(
                getUri("/api/accounts/") + idToDelete, AccountResponseDto.class
        );

        assertEquals(HttpStatus.NOT_FOUND, getDetailResponse.getStatusCode());
        assertFalse(getDetailResponse.hasBody());
    }
}