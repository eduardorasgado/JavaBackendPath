package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.AccountTestData;
import com.eduardorasgado.app.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    @Test
    void detail() throws Exception {
        // Given
        when(accountService.findById(1L)).thenReturn(AccountTestData.getNewAccount001().orElseThrow());

        // When
        mvc.perform(MockMvcRequestBuilders
                    .get("/api/accounts/1")
                    .contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Adam Smith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(1000));

        verify(accountService).findById(1L);
    }
}