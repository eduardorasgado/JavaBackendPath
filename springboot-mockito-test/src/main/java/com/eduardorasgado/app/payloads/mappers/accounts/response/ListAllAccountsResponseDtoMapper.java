package com.eduardorasgado.app.payloads.mappers.accounts.response;

import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;

import java.util.ArrayList;
import java.util.List;

public class ListAllAccountsResponseDtoMapper {
    public static ListAllAccountsResponseDto mapModelToDto(List<Account> modelAccountList, ListAllAccountsResponseDto responseDto) {
        List<ListAllAccountsResponseDto.AccountResponseDto> responseDtoList = new ArrayList<>();

        modelAccountList.forEach(modelAccount -> {
            ListAllAccountsResponseDto.AccountResponseDto dto = new ListAllAccountsResponseDto.AccountResponseDto();

            dto.setId(modelAccount.getId());
            dto.setName(modelAccount.getName());
            dto.setBalance(modelAccount.getBalance());

            responseDto.getAccounts().add(dto);
        });

        return responseDto;
    }
}
