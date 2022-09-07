package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class SavingAccountTest {

    @Test
    public void shouldCreateSavingAccountWhenValidInput() {
        //region given
        int clientId = 1;
        String clientName = "clientName";
        int accountId = 10;
        double accountAmount = 10.0;
        Client client = new Client(clientId, clientName);
        //endregion

        //region when
        SavingAccount account = new SavingAccount(accountId, client, accountAmount);
        //endregion

        //region then
        assertNotNull(account);
        //endregion
    }

    @Test
    public void shouldNotCreateSavingAccountWhenInvalidAmount() {
        //region given
        int clientId = 1;
        String clientName = "clientName";
        int accountId = 10;
        double accountAmount = -0.1;
        Client client = new Client(clientId, clientName);
        //endregion
        SavingAccount account;
        //region when
        try {
            account = new SavingAccount(accountId, client, accountAmount);
        } catch (IllegalArgumentException e) {
        }
        //endregion

        //region then

//        assertNotNull(account);
        //endregion
    }
}
//region given
//endregion

//region when
//endregion

//region then
//endregion