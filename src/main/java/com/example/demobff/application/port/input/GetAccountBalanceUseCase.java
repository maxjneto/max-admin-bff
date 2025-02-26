package com.example.demobff.application.port.input;

import com.example.demobff.application.dto.AccountDepositDTO;
import com.example.demobff.application.dto.AccountWithdrawalDTO;
import com.example.demobff.application.dto.TransferDTO;

import java.util.List;

public interface GetAccountBalanceUseCase {

    List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber);

    List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber);

    List<TransferDTO> listAllTransfersByAccountId(Long id);

    List<TransferDTO> listSentTransfersByAccountId(Long id);

    List<TransferDTO> listReceivedTransfersByAccountId(Long id);

}
