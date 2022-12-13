package com.eduardorasgado.app.payloads.dtos.accounts.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
@NoArgsConstructor
public class TransactionRequestDto {
    private Long originAccountId;

    private Long destinationAccountId;

    private Long bankId;

    private BigDecimal amount;
}
