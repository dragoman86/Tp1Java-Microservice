package tn.iteam.services;

import tn.iteam.dtos.AccountDto;
import tn.iteam.entities.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccounts();
    void saveAccount(AccountDto accountDto);
    AccountDto findAccountById(String id);

}
