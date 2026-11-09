package tn.iteam.services;

import org.springframework.stereotype.Service;
import tn.iteam.dtos.AccountDto;
import tn.iteam.entities.Account;
import tn.iteam.exceptions.AccountsAlreadyExistsException;
import tn.iteam.exceptions.AccountsNotFoundException;
import tn.iteam.mappers.AccountMapper;
import tn.iteam.repos.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty()) {
            throw new AccountsNotFoundException("Account", "list", "No accounts found");
        }
        return accounts;
    }

    @Override
    public void saveAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto, new Account());
        if (accountRepository.existsById(account.getAccountId())) {
            throw new AccountsAlreadyExistsException("Account", "accountId", account.getAccountId());
        }
        accountRepository.save(account);
    }

    @Override
    public AccountDto findAccountById(String id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new AccountsNotFoundException("Account", "accountId", id)
        );
        return AccountMapper.mapToAccountDto(account, new AccountDto());
    }


}
