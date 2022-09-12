package com.acme.banking.dbo.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Client {
    private int id; // not null && > 0
    private String name; // not empty && not null
    private Collection<Account> accounts = new ArrayList<>(); //TODO

    public Client(int id, String name, Account accountDoubler) {
        if (id <= 0) throw new IllegalArgumentException("Id должен быть больше 0");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name не должен быть null лии пустым");

        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public double getAccountsSum() {
        double sum = 0;
        for (Account account: accounts) {
            sum += account.getAmount();
        }

        return sum;
    }
}
