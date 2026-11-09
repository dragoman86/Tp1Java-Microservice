package tn.iteam.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import tn.iteam.enums.AccountType;
import tn.iteam.models.Customer;

import java.time.LocalDate;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
