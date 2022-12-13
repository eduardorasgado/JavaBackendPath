package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.AccountTestData;
import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
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

        mvc.perform(MockMvcRequestBuilders
                    .post("/api/accounts/transfer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(transactionRequestDto))
                )
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
                                                    .value(transactionRequestDto.getAmount()));



    }
}