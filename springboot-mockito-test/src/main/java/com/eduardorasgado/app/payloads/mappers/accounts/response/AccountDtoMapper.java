package com.eduardorasgado.app.payloads.mappers.accounts.response;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.response.AccountDto;

public class AccountDtoMapper {

    public static AccountDto map(Account model, AccountDto dto) {
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setBalance(model.getBalance());

        return dto;
    }
}
