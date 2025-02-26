package com.example.demobff.domain.service;

import com.example.demobff.application.dto.*;
import com.example.demobff.application.port.output.ManageAccountOutput;
import com.example.demobff.application.port.output.ManageCustomerOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManageAccountServiceTests {

    @Mock
    private ManageAccountOutput manageAccountOutput;

    @InjectMocks
    private ManageAccountService manageAccountService;


    @Test
    void listAllTransfersByAccountIdReturnsTransfers() {
        TransferDTO transferDTO = new TransferDTO(new Date(),
                new SimpleAccountDTO(1L, "123"),
                new SimpleAccountDTO(2L, "456"), 100.0, "PIX");

        when(manageAccountOutput.listAllTransfersByAccountId(1L)).thenReturn(List.of(transferDTO));

        List<TransferDTO> result = manageAccountService.listAllTransfersByAccountId(1L);

        assertEquals(List.of(transferDTO), result);
    }

    @Test
    void listSentTransfersByAccountIdReturnsTransfers() {
        TransferDTO transferDTO = new TransferDTO(new Date(),
                new SimpleAccountDTO(1L, "123"),
                new SimpleAccountDTO(2L, "456"), 100.0, "PIX");

        when(manageAccountOutput.listSentTransfersByAccountId(1L)).thenReturn(List.of(transferDTO));

        List<TransferDTO> result = manageAccountService.listSentTransfersByAccountId(1L);

        assertEquals(List.of(transferDTO), result);
    }

    @Test
    void listReceivedTransfersByAccountIdReturnsTransfers() {
        TransferDTO transferDTO = new TransferDTO(new Date(),
                new SimpleAccountDTO(1L, "123"),
                new SimpleAccountDTO(2L, "456"), 100.0, "PIX");

        when(manageAccountOutput.listReceivedTransfersByAccountId(2L)).thenReturn(List.of(transferDTO));

        List<TransferDTO> result = manageAccountService.listReceivedTransfersByAccountId(2L);

        assertEquals(List.of(transferDTO), result);
    }

    @Test
    void listDepositsByAccountNumberReturnsDeposits() {
        AccountDepositDTO depositDTO = new AccountDepositDTO(10.0,new Date());

        when(manageAccountOutput.listDepositsByAccountNumber("123")).thenReturn(List.of(depositDTO));

        List<AccountDepositDTO> result = manageAccountService.listDepositsByAccountNumber("123");

        assertEquals(List.of(depositDTO), result);
    }

    @Test
    void listWithdrawalsByAccountNumberReturnsDeposits() {
        AccountWithdrawalDTO withdrawalDTO = new AccountWithdrawalDTO(10.0,new Date());

        when(manageAccountOutput.listWithdrawalsByAccountNumber("123")).thenReturn(List.of(withdrawalDTO));

        List<AccountWithdrawalDTO> result = manageAccountService.listWithdrawalsByAccountNumber("123");

        assertEquals(List.of(withdrawalDTO), result);
    }


}
