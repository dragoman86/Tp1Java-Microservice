package tn.iteam.web;

import jakarta.validation.Valid;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.bridges.CustomerOpenFeignClients;
import tn.iteam.dtos.AccountDto;
import tn.iteam.dtos.ResponseDto;
import tn.iteam.entities.Account;
import tn.iteam.enums.AccountRespStatus;
import tn.iteam.models.Customer;
import tn.iteam.services.AccountService;

import java.util.List;

@RestController
public class AccountRestController {
    private final AccountService accountService;
    private final Environment environment;
    private final CustomerOpenFeignClients customerOpenFeignClients;

    public AccountRestController(AccountService accountService, Environment environment, CustomerOpenFeignClients customerOpenFeignClients) {
        this.accountService = accountService;
        this.environment = environment;
        this.customerOpenFeignClients = customerOpenFeignClients;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> retrieveAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> retrieveOneAccount(@PathVariable String id) {
        AccountDto accountDto = accountService.findAccountById(id);
        //Getting customer from customer micro-service
        Customer customer = customerOpenFeignClients.findCustomerById(accountDto.getCustomerId());
        accountDto.setCustomer(customer);
        //End
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("/accounts")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody AccountDto accountDto) {
        accountService.saveAccount(accountDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountRespStatus.CREATED.getCode(),
                        AccountRespStatus.CREATED.getMessage()));
    }
}
