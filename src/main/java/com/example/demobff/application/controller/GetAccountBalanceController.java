package com.example.demobff.application.controller;

import com.example.demobff.application.dto.AccountDepositDTO;
import com.example.demobff.application.dto.AccountWithdrawalDTO;
import com.example.demobff.application.dto.TransferDTO;
import com.example.demobff.domain.service.ManageAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetAccountBalanceController {

    private static final Logger logger = LogManager.getLogger(GetAccountBalanceController.class);

    @Autowired
    private ManageAccountService manageAccountService;

    @GetMapping("/info/saque/{numeroConta}")
    public ResponseEntity<List<AccountWithdrawalDTO>> listWithdrawalsByAccountNumber(@PathVariable String numeroConta) {
        List<AccountWithdrawalDTO> withdrawals = manageAccountService.listWithdrawalsByAccountNumber(numeroConta);
        logger.info("Found all withdrawals from customer with account number: " + numeroConta);
        return ResponseEntity.ok(withdrawals);
    }

    @GetMapping("/info/deposito/{numeroConta}")
    public ResponseEntity<List<AccountDepositDTO>> listDepositsByAccountNumber(@PathVariable String numeroConta) {
        List<AccountDepositDTO> deposits = manageAccountService.listDepositsByAccountNumber(numeroConta);
        logger.info("Found all deposits from customer with account number: " + numeroConta);
        return ResponseEntity.ok(deposits);
    }

    @GetMapping("/info/transferencias/todas/{id}")
    public ResponseEntity<List<TransferDTO>> listAllTransfersByAccountId(@PathVariable long id) {
        List<TransferDTO> transfers = manageAccountService.listAllTransfersByAccountId(id);
        logger.info("Found all transfers from customer with id: " + id);
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/info/transferencias/enviadas/{id}")
    public ResponseEntity<List<TransferDTO>> listSentTransfersByAccountId(Long id) {
        List<TransferDTO> transfers = manageAccountService.listSentTransfersByAccountId(id);
        logger.info("Found all transfers sent by customer with id: " + id);
        return ResponseEntity.ok(transfers);
    }

    @GetMapping("/info/transferencias/recebidas/{id}")
    public ResponseEntity<List<TransferDTO>> listReceivedTransfersByAccountId(Long id) {
        List<TransferDTO> transfers = manageAccountService.listReceivedTransfersByAccountId(id);
        logger.info("Found all transfers received by customer with id: " + id);
        return ResponseEntity.ok(transfers);
    }


}
