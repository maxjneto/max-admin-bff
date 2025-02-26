package com.example.demobff.application.controller;

import com.example.demobff.application.dto.*;
import com.example.demobff.domain.service.ManageAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAccountBalanceControllerTests {

    @InjectMocks
    private GetAccountBalanceController getAccountBalanceController;

    @Mock
    private ManageAccountService manageAccountService;

    @Test
    void listAllTransfersByAccountIdReturnOk() {
        List<TransferDTO> transfersMock = List.of(new TransferDTO( new Date(),
                new SimpleAccountDTO(1L,"123"),new SimpleAccountDTO(2L,"456"),
                100.0,"PIX"));
        when(manageAccountService.listAllTransfersByAccountId(1L)).thenReturn(transfersMock);

        ResponseEntity<List<TransferDTO>> response = getAccountBalanceController.listAllTransfersByAccountId(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(transfersMock);
    }

    @Test
    void listSentTransfersByAccountIdReturnOk() {
        List<TransferDTO> transfersMock = List.of(new TransferDTO( new Date(),
                new SimpleAccountDTO(1L,"123"),new SimpleAccountDTO(2L,"456"),
                100.0,"PIX"));
        when(manageAccountService.listSentTransfersByAccountId(1L)).thenReturn(transfersMock);

        ResponseEntity<List<TransferDTO>> response = getAccountBalanceController.listSentTransfersByAccountId(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(transfersMock);
    }

    @Test
    void listReceivedTransfersByAccountIdReturnOk() {
        List<TransferDTO> transfersMock = List.of(new TransferDTO( new Date(),
                new SimpleAccountDTO(1L,"123"),new SimpleAccountDTO(2L,"456"),
                100.0,"PIX"));
        when(manageAccountService.listReceivedTransfersByAccountId(2L)).thenReturn(transfersMock);

        ResponseEntity<List<TransferDTO>> response = getAccountBalanceController.listReceivedTransfersByAccountId(2L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(transfersMock);
    }

    @Test
    void listDepositsByAccountNumberReturnOk() {
        List<AccountDepositDTO> depositMock = List.of(new AccountDepositDTO( 100.0,new Date()));
        when(manageAccountService.listDepositsByAccountNumber("1234")).thenReturn(depositMock);

        ResponseEntity<List<AccountDepositDTO>> response = getAccountBalanceController.listDepositsByAccountNumber("1234");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(depositMock);
    }

    @Test
    void listWithdrawalsByAccountNumberReturnOk() {
        List<AccountWithdrawalDTO> withdrawalMock = List.of(new AccountWithdrawalDTO( 100.0,new Date()));
        when(manageAccountService.listWithdrawalsByAccountNumber("1234")).thenReturn(withdrawalMock);

        ResponseEntity<List<AccountWithdrawalDTO>> response = getAccountBalanceController.listWithdrawalsByAccountNumber("1234");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(withdrawalMock);
    }

}
