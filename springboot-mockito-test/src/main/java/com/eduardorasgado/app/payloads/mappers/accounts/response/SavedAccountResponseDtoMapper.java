package com.eduardorasgado.app.payloads.mappers.accounts.response;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.response.SavedAccountResponseDto;

public class SavedAccountResponseDtoMapper {
    public static SavedAccountResponseDto mapModelToDto(Account account, SavedAccountResponseDto dto) {
        SavedAccountResponseDto.AccountResponseDto accountResponseDto = new SavedAccountResponseDto.AccountResponseDto();
        accountResponseDto.setId(account.getId());
        accountResponseDto.setName(account.getName());
        accountResponseDto.setBalance(account.getBalance());

        dto.setAccount(accountResponseDto);
        return dto;
    }
}
