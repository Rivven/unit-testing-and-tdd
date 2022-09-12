package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Cash;
import com.acme.banking.dbo.persist.AccountRepository;
import com.acme.banking.dbo.persist.ClientRepository;
import com.acme.banking.dbo.service.Processing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProcessingTest {
    @Mock private Account accountDoubler;
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)//(для незаданной функции findById вернет не Null,а заглушку Client
    private ClientRepository clientRepositoryDoubler;
    //@Mock private Client clientDoubler;//лишний. убрали с помощью цепочки ниже
    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private AccountRepository accountRepositoryDoubler;

    @Mock private Cash cashDoubler;
    @InjectMocks private Processing sut;
    private double amountDoubler;

    @BeforeEach
    public void setUp()
    {
        amountDoubler = 100.0;
    }

    @Test
    public void shoudGetAccountsForClientWhenClientExistsWithAccounts(){
        //when(clientDoubler.getAccounts()).thenReturn(Collections.singletonList(accountDoubler));
        //when(clientRepositoryDoubler.findById(1)).thenReturn(clientDoubler);

        when(clientRepositoryDoubler.findById(1).getAccounts())
                .thenReturn(singletonList(accountDoubler));

        assertThat(sut.getAccountsByClientId(1)
                .contains(accountDoubler));
    }

    @Test
    public void shoudSaveCorrectAccountsWhenTransfer(){
        Account to = mock(Account.class);

        when(accountRepositoryDoubler.findById(1)).thenReturn(accountDoubler);
        when(accountRepositoryDoubler.findById(2)).thenReturn(to);

        sut.transfer(1,2,amountDoubler);

        verify(accountRepositoryDoubler).save(accountDoubler);
    }

    @Test
    public void shoudCashLogWhenWithdraw(){
        when(accountRepositoryDoubler.findById(1)).thenReturn(accountDoubler);

        sut.cash(amountDoubler, 1);

        verify(accountRepositoryDoubler).save(accountDoubler);
    }

    @Test
    public void errorWhenWithdrawWithNotExistAccount(){
        when(accountRepositoryDoubler.findById(2)).thenReturn(null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> sut.cash(amountDoubler, 2));
        verify(accountRepositoryDoubler, times(0)).save(null);
    }
}
