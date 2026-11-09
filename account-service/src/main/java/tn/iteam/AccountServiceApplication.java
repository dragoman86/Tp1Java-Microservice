package tn.iteam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.iteam.entities.Account;
import tn.iteam.enums.AccountType;
import tn.iteam.repos.AccountRepository;

import java.time.LocalDate;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);

        System.out.println("****Account Service Application Started succesfully****");
    }

    @Bean
    public CommandLineRunner initData(AccountRepository repository) {
        return args -> {
            Account account1 = Account.builder()
                    .accountId("ACC001")
                    .balance(1000)
                    .createdAt(LocalDate.now())
                    .currency("TND")
                    .type(AccountType.CURRENT_ACCOUNT)
                    .customerId(1L)
                    .build();
            repository.save(account1);

            Account account2 = Account.builder()
                    .accountId("ACC002")
                    .balance(2500)
                    .createdAt(LocalDate.now())
                    .currency("TND")
                    .type(AccountType.SAVING_ACCOUNT)
                    .customerId(2L)
                    .build();
            repository.save(account2);
        };
    }
}
