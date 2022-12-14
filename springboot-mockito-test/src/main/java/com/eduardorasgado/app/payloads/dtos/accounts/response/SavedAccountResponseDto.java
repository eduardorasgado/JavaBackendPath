package com.eduardorasgado.app.payloads.dtos.accounts.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SavedAccountResponseDto {
    private String message;

    private AccountResponseDto account;

    @Getter
    @Setter
    @NoArgsConstructor
    public class AccountResponseDto {
        private long id;

        private String name;

        private BigDecimal balance;
    }

}
