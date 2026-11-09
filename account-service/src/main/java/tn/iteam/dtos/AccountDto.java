package tn.iteam.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import tn.iteam.enums.AccountType;
import tn.iteam.models.Customer;

import java.time.LocalDate;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class AccountDto {
    @NotBlank
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType type;
    private Customer customer;
    private Long customerId;
}
