package com.example.demobff.application.port.input;

import com.example.demobff.application.dto.AccountDTO;

import java.util.List;

public interface GetAccountUseCase {

    List<AccountDTO> listAccountsByCustomerId(Long id);

    AccountDTO getAccountByNumber(String accountNumber);

}
