package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.exceptions.NotEnoughMoneyException;
import com.eduardorasgado.app.payloads.dtos.accounts.request.AccountToSaveRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.request.TransactionRequestDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.AccountResponseDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.ListAllAccountsResponseDto;
import com.eduardorasgado.app.payloads.dtos.accounts.response.SavedAccountResponseDto;
import com.eduardorasgado.app.payloads.mappers.accounts.response.AccountResponseDtoMapper;
import com.eduardorasgado.app.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListAllAccountsResponseDto listAll() {
        return null;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponseDto detail(@PathVariable(name = "id") Long id) {
        return AccountResponseDtoMapper.mapModelToDto(accountService.findById(id), new AccountResponseDto());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SavedAccountResponseDto save(@RequestBody AccountToSaveRequestDto accountToSaveRequestDto) {
        return null;
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransactionRequestDto transactionRequestDto) {
        try {
            accountService.transfer(
                    transactionRequestDto.getOriginAccountId(),
                    transactionRequestDto.getDestinationAccountId(),
                    transactionRequestDto.getBankId(),
                    transactionRequestDto.getAmount()
            );
        } catch (NotEnoughMoneyException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now().toString());
        response.put("status", "OK");
        response.put("message", "Transfer was successfully performed");
        response.put("transaction", transactionRequestDto);

        return ResponseEntity.ok(response);
    }
}
