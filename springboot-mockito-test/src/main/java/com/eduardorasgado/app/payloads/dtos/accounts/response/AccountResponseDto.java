package com.eduardorasgado.app.payloads.dtos.accounts.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class AccountResponseDto {
    private long id;

    private String name;

    private BigDecimal balance;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountResponseDto that = (AccountResponseDto) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && getBalance().compareTo(that.getBalance()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getBalance());
    }
}
