package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;



@DisplayName("Test suite")
@ExtendWith(MockitoExtension.class)
public class ClientTest {
    @Mock
    private Account accountDoubler;
    private int dummyId;
    private String dummyName;

    @BeforeEach
    public void setUp()
    {
        dummyId = 1;
        dummyName = "dummy name";
    }

    @Test @Disabled("temporary disabled")
    @DisplayName("Test case")
    public void shouldStorePropertiesWhenCreated() {
        //region given
        final int clientId = 1;
        final String clientName = "dummy client name";
        //endregion

        //region when
        Client sut = new Client(clientId, clientName, accountDoubler);
        assumeTrue(sut != null);
        //endregion

        //region then
        //Junit5:
        assertAll("Client store its properties",
                () -> assertEquals(clientId, sut.getId()),
                () -> assertEquals(clientName, sut.getName())
        );

        //Hamcrest:
        assertThat(sut,
            allOf(
                hasProperty("id", notNullValue()),
                hasProperty("id", equalTo(clientId)),
                hasProperty("name", is(clientName))
        ));

        //AssertJ:
        org.assertj.core.api.Assertions.assertThat(sut)
                .hasFieldOrPropertyWithValue("id", clientId)
                .hasFieldOrPropertyWithValue("name", clientName);
        //also take a look at `extracting()` https://stackoverflow.com/a/51812188
        //endregion
    }
    @Test
    @Disabled("temporary disabled")
    public void shoudCreateWhenValidData() {
        Client sut = new Client(dummyId, dummyName, accountDoubler);
        assertTrue(sut.getAccounts().contains(accountDoubler));
    }
    @Test
    @Disabled("temporary disabled")
    public void shourGetAllAmountsWhenGetAccountSum() {
        int dummyId = 1;
        String dummnyName = "dummy";
        Client sut = new Client(dummyId, dummnyName, accountDoubler);
        sut.getAccountsSum();

        //verify(accountDoubler).getAmount();//any(MyClass.class)
    }
}
