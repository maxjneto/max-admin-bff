package com.example.demobff.domain.service;

import com.example.demobff.application.dto.AccountDepositDTO;
import com.example.demobff.application.dto.AccountWithdrawalDTO;
import com.example.demobff.application.dto.TransferDTO;
import com.example.demobff.application.port.input.GetAccountBalanceUseCase;
import com.example.demobff.application.port.output.ManageAccountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageAccountService implements GetAccountBalanceUseCase {

    @Autowired
    private ManageAccountOutput accountOutput;

    @Override
    public List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber) {
        return accountOutput.listWithdrawalsByAccountNumber(accountNumber);
    }

    @Override
    public List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber) {
        return accountOutput.listDepositsByAccountNumber(accountNumber);
    }

    @Override
    public List<TransferDTO> listAllTransfersByAccountId(Long id) {
        return accountOutput.listAllTransfersByAccountId(id);
    }

    @Override
    public List<TransferDTO> listSentTransfersByAccountId(Long id) {
        return accountOutput.listSentTransfersByAccountId(id);
    }

    @Override
    public List<TransferDTO> listReceivedTransfersByAccountId(Long id) {
        return accountOutput.listReceivedTransfersByAccountId(id);
    }
}
