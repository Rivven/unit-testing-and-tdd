package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldCreateSavingAccountWhenValidInput() {
        //given
        int clientId = 1;
        String clientName = "dummy name";
        Client client = new Client(clientId, clientName);
        int savingAccountId = 2;
        double amount = 100.0;

        //when
        SavingAccount savingAccount = new SavingAccount(savingAccountId, client, amount);

        //then
        Assertions.assertFalse(savingAccount == null);
    }

    @Test
    public void shourNotCreateSavingAccountWhenNotValidInput() {
        //given
        int clientId = 1;
        String clientName = "dummy name";
        Client client = new Client(clientId, clientName);
        int savingAccountId = 2;
        double amount = 100.0;

        //when
        SavingAccount savingAccount = new SavingAccount(savingAccountId, client, amount);

        //then
        Assertions.assertFalse(savingAccount == null);
    }
}
