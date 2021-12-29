package com.koios.test.bootstrap;

import com.koios.test.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public BootStrapData(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        System.out.println("Number of accounts: " + accountRepository.count());

    }
}
