package com.example.demobff.domain.service;

import com.example.demobff.application.dto.AccountDTO;
import com.example.demobff.application.port.input.GetAccountUseCase;
import com.example.demobff.application.port.output.GetAccountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAccountService implements GetAccountUseCase {

    @Autowired
    private GetAccountOutput accountOutput;

    @Override
    public List<AccountDTO> listAccountsByCustomerId(Long id) {
        return accountOutput.listAccountsByCustomerId(id);
    }

    @Override
    public AccountDTO getAccountByNumber(String accountNumber) {
        return accountOutput.getAccountByNumber(accountNumber);
    }
}
