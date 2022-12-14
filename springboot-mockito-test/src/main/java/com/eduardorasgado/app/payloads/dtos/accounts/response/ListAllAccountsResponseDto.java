package com.eduardorasgado.app.payloads.dtos.accounts.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ListAllAccountsResponseDto {
    private List<AccountResponseDto> accounts = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AccountResponseDto {
        private long id;

        private String name;

        private BigDecimal balance;
    }
}
