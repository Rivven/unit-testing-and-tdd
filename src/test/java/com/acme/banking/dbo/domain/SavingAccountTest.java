package com.acme.banking.dbo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(accountId, account.getId());
        assertEquals(client, account.getClient());
        assertEquals(accountAmount, account.getAmount());
        //endregion

        //region then
        assertNotNull(account);
        //endregion
    }

    @Test
    public void shouldCreateSavingAccountWhenValidInput2() {
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
        org.assertj.core.api.Assertions.assertThat(account)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", accountId)
                .hasFieldOrPropertyWithValue("Client", client)
                .hasFieldOrPropertyWithValue("amount", accountAmount);
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
            account= null;
        }
        //endregion

        //region then
        assertNull(account);
        //endregion
    }

    @Test
    public void shouldNotCreateSavingAccountWhenInvalidclientId() {
        //region given
        int clientId = 0;
        String clientName = "clientName";
        int accountId = 10;
        double accountAmount = 0.1;
        Client client = new Client(clientId, clientName);
        //endregion
        SavingAccount account;
        //region when

        try {
            account = new SavingAccount(accountId, client, accountAmount);
        } catch (IllegalArgumentException e) {
            account= null;
        }
        //endregion

        //region then
        org.assertj.core.api.Assertions.assertThat(account)
                .isNull();
        //endregion
    }

    @Test
    public void shouldNotCreateSavingAccountWhenInvalidclientIdHowWithHamcrest() {
        int clientId = 0;
        String clientName = "clientName";
        int accountId = 10;
        double accountAmount = 0.1;
        Client client = new Client(clientId, clientName);

        SavingAccount account;
//        org.assertj.core.api.Assertions.catchThrowable(() -> new SavingAccount(accountId, client, accountAmount))
//                .getSuppressed()
//                .getClass(IllegalArgumentException.class);
    }

}
//region given
//endregion

//region when
//endregion

//region then
//endregion