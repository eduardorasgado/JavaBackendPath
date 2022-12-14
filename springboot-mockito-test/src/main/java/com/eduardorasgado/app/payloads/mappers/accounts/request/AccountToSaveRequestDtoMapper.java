package com.eduardorasgado.app.payloads.mappers.accounts.request;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.request.AccountToSaveRequestDto;

public class AccountToSaveRequestDtoMapper {
    public static Account mapDtoToModel(AccountToSaveRequestDto dto, Account account) {
        account.setName(dto.getName());
        account.setBalance(dto.getBalance());
        return account;
    }
}
