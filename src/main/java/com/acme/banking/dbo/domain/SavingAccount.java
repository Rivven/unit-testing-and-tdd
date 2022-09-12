package com.acme.banking.dbo.domain;

public class SavingAccount implements Account {
    private int id;
    private Client client;
    private double amount; // >=0

    public SavingAccount(int id, Client client, double amount) {
        if (id <= 0) throw new IllegalArgumentException("Id должен быть больше 0");
        if (amount < 0) throw new IllegalArgumentException("amount не должен быть null лии пустым");
        if (client == null) throw new IllegalArgumentException("client не должен быть null");

        this.id = id;
        this.client = client;
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
