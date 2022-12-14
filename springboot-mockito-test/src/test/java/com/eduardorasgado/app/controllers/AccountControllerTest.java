package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.AccountTestData;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;
import com.eduardorasgado.app.payloads.mappers.accounts.response.ListAllAccountsResponseDtoMapper;
import com.eduardorasgado.app.services.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    /*
    This is to mock http request servlet, responses
    * */
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void testDetail() throws Exception {
        // Given
        when(accountService.findById(1L)).thenReturn(AccountTestData.getNewAccount001().orElseThrow());

        // When
        mvc.perform(MockMvcRequestBuilders
                    .get("/api/accounts/1")
                    .contentType(MediaType.APPLICATION_JSON)
                )
                // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                // $. at jsonPath indicates the root of the json object
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Adam Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(1000));

        verify(accountService).findById(1L);
    }

    @Test
    void testTransfer() throws Exception {
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setOriginAccountId(1L);
        transactionRequestDto.setDestinationAccountId(2L);
        transactionRequestDto.setBankId(1L);
        transactionRequestDto.setAmount(new BigDecimal("500"));

        //System.out.println(objectMapper.writeValueAsString(transactionRequestDto));

        // expected (map object version)
        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "OK");
        response.put("message", "Transfer was successfully performed");
        response.put("transaction", transactionRequestDto);

        //System.out.println(objectMapper.writeValueAsString(response));

        mvc.perform(MockMvcRequestBuilders
                    .post("/api/accounts/transfer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(transactionRequestDto))
                )
                // expected, already mapped to json version
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.date").value(LocalDate.now().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                                                    .value("Transfer was successfully performed"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction.originAccountId")
                                                    .value(transactionRequestDto.getOriginAccountId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction.destinationAccountId")
                                                    .value(transactionRequestDto.getDestinationAccountId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction.bankId")
                                                    .value(transactionRequestDto.getBankId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transaction.amount")
                                                    .value(transactionRequestDto.getAmount()))

                // inserting the mapped version of expected json
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    void testListAll() throws Exception {
        // Given
        List<Account> accounts = Arrays.asList(
                AccountTestData.getNewAccount001().orElseThrow(),
                AccountTestData.getNewAccount002().orElseThrow()
        );

        ListAllAccountsResponseDto responseDto = new ListAllAccountsResponseDto();
        ListAllAccountsResponseDtoMapper.mapModelToDto(accounts, responseDto);

        when(accountService.findAll()).thenReturn(accounts);

        // When
        mvc.perform(MockMvcRequestBuilders
                    .get("/api/accounts")
                    .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))

                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].name").value("Adam Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[0].balance").value(new BigDecimal("1000")))

                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[1].id").value(2L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[1].name").value("John Finn"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accounts[1].balance").value(new BigDecimal("2000")))
                //.andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(responseDto)))
                ;
    }
}