package com.example.demobff.application.port.output;

import com.example.demobff.application.dto.AccountDTO;

import java.util.List;

public interface GetAccountOutput {

    List<AccountDTO> listAccountsByCustomerId(Long id);

    AccountDTO getAccountByNumber(String accountNumber);

}
