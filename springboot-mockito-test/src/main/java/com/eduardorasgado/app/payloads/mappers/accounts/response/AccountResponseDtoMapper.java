package com.eduardorasgado.app.payloads.mappers.accounts.response;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.response.AccountResponseDto;

public class AccountResponseDtoMapper {

    public static AccountResponseDto mapModelToDto(Account model, AccountResponseDto dto) {
        dto.setId(model.getId());
        dto.setName(model.getName());
        dto.setBalance(model.getBalance());

        return dto;
    }
}
