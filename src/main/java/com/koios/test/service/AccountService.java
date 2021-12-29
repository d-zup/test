package com.koios.test.service;

import com.koios.test.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();

    void saveAccount(Account account);

    Account getAccountById(long id);

    void deleteAccountById(long id);

}
