package tn.iteam.mappers;

import tn.iteam.dtos.AccountDto;
import tn.iteam.entities.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account, AccountDto accountDto) {
        accountDto.setAccountId(account.getAccountId());
        accountDto.setBalance(account.getBalance());
        accountDto.setCreatedAt(account.getCreatedAt());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setType(account.getType());
        accountDto.setCustomer(account.getCustomer());
        accountDto.setCustomerId(account.getCustomerId());
        return accountDto;
    }

    public static Account mapToAccount(AccountDto accountDto, Account account) {
        account.setAccountId(accountDto.getAccountId());
        account.setBalance(accountDto.getBalance());
        account.setCreatedAt(accountDto.getCreatedAt());
        account.setCurrency(accountDto.getCurrency());
        account.setType(accountDto.getType());
        account.setCustomer(accountDto.getCustomer());
        account.setCustomerId(accountDto.getCustomerId());
        return account;
    }
}
