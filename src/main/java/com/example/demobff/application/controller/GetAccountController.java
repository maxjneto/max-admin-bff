package com.example.demobff.application.controller;

import com.example.demobff.application.dto.AccountDTO;
import com.example.demobff.application.dto.AccountWithdrawalDTO;
import com.example.demobff.domain.service.GetAccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAccountController {

    private static final Logger logger = LogManager.getLogger(GetAccountController.class);

    @Autowired
    private GetAccountService getAccountService;

    @GetMapping("/info/conta/numero/{numeroConta}")
    public ResponseEntity<AccountDTO> getAccountByNumber(@PathVariable String numeroConta) {
        AccountDTO account = getAccountService.getAccountByNumber(numeroConta);
        logger.info("Found account with number: " + numeroConta);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/info/conta/{id}")
    public ResponseEntity<List<AccountDTO>> listAccountsByCustomerId(@PathVariable long id) {
        List<AccountDTO> accounts = getAccountService.listAccountsByCustomerId(id);
        logger.info("Found all accounts from customer with id: " + id);
        return ResponseEntity.ok(accounts);
    }

}
