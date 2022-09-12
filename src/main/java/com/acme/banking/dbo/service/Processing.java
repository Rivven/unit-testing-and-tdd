package com.acme.banking.dbo.service;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Cash;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.persist.AccountRepository;
import com.acme.banking.dbo.persist.ClientRepository;

import java.util.Collection;

public class Processing {
    private ClientRepository clientRepository;
    private AccountRepository accountRepository;
    private Cash cash;

    public Processing(ClientRepository clientRepository,
                      AccountRepository accountRepository,
                      Cash cash) {
        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.cash = cash;
    }

    public Client createClient(String name) {
        return null; //TODO
    }

    public Collection<Account> getAccountsByClientId(int clientId) {
        Client client = clientRepository.findById(clientId);
        return client.getAccounts();
    }

    public void transfer(int fromAccountId, int toAccountId, double amount) {
        Account from = accountRepository.findById(fromAccountId);
        Account to = accountRepository.findById(toAccountId);

        from.setAmount(from.getAmount() - amount);
        to.setAmount(to.getAmount() + amount);

        accountRepository.save(from);
        accountRepository.save(to);
    }

    public void cash(double amount, int fromAccountId) {
        Account from = accountRepository.findById(fromAccountId);

        if(from == null) {
            throw new IllegalArgumentException("account not exists");
        }

        from.setAmount(from.getAmount() - amount);

        cash.log(amount, fromAccountId);

        accountRepository.save(from);
    }
}
