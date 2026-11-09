package tn.iteam.web;

import jakarta.validation.Valid;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.iteam.dtos.AccountDto;
import tn.iteam.dtos.ResponseDto;
import tn.iteam.entities.Account;
import tn.iteam.enums.AccountRespStatus;
import tn.iteam.services.AccountService;

import java.util.List;

@RestController
public class AccountRestController {
    private final AccountService accountService;
    private final Environment environment;

    public AccountRestController(AccountService accountService, Environment environment) {
        this.accountService = accountService;
        this.environment = environment;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> retrieveAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> retrieveOneAccount(@PathVariable String id) {
        AccountDto accountDto = accountService.findAccountById(id);
        accountDto.setEnvironment(environment.getProperty("server.port"));
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
