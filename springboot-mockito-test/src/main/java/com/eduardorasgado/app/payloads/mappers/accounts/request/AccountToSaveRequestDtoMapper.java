package com.eduardorasgado.app.payloads.mappers.accounts.request;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.request.AccountToSaveRequestDto;

public class AccountToSaveRequestDtoMapper {
    public static Account mapDtoToModel(AccountToSaveRequestDto dto, Account model) {
        model.setName(dto.getName());
        model.setBalance(dto.getBalance());
        return model;
    }

    public static AccountToSaveRequestDto mapModelToDto(Account model, AccountToSaveRequestDto dto) {
        dto.setName(model.getName());
        dto.setBalance(model.getBalance());
        return dto;
    }
}
