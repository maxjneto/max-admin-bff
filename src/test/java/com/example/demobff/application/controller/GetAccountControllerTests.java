package com.example.demobff.application.controller;

import com.example.demobff.application.dto.*;
import com.example.demobff.domain.exception.EntityNotFoundException;
import com.example.demobff.domain.service.GetAccountService;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAccountControllerTests {

    @InjectMocks
    private GetAccountController getAccountController;

    @Mock
    private GetAccountService getAccountService;

    @Test
    void getAccountByNumberReturnOk() {
        AccountDTO accountMock = new AccountDTO(1L,1L,"123",100.0);
        when(getAccountService.getAccountByNumber("123")).thenReturn(accountMock);

        ResponseEntity<AccountDTO> response = getAccountController.getAccountByNumber("123");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(accountMock);
    }

    @Test
    void listAccountsByCustomerIdReturnOk() {
        List<AccountDTO> accountMock = List.of(new AccountDTO(1L,1L,
                "123",100.0));
        when(getAccountService.listAccountsByCustomerId(1L)).thenReturn(accountMock);

        ResponseEntity<List<AccountDTO>> response = getAccountController.listAccountsByCustomerId(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(accountMock);
    }


    @Test
    void listAccountsByCustomerIdReturnNotFound() {
        doThrow(new EntityNotFoundException("Cliente não encontrado"))
                .when(getAccountService).listAccountsByCustomerId(10000L);

        assertThrows(EntityNotFoundException.class, () -> {
            getAccountController.listAccountsByCustomerId(10000L);
        });

    }

}
