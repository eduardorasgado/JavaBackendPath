package com.eduardorasgado.app.controllers;

import com.eduardorasgado.app.exceptions.NotEnoughMoneyException;
import com.eduardorasgado.app.models.Account;
import com.eduardorasgado.app.payloads.request.TransactionRequestDto;
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account detail(@PathVariable(name = "id") Long id) {
        return accountService.findById(id);
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
            return null;
        }

        Map<String, Object> response = new HashMap<>();
        response.put("date", LocalDate.now());
        response.put("status", "OK");
        response.put("message", "Transfer was successfully performed");
        response.put("transaction", transactionRequestDto);

        return ResponseEntity.ok(response);
    }
}
