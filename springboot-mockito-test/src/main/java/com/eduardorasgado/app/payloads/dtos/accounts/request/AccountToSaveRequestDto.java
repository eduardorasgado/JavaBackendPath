package com.eduardorasgado.app.payloads.dtos.accounts.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class AccountToSaveRequestDto {
    //private long id;

    private String name;

    private BigDecimal balance;
}
