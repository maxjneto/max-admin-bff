package com.example.demobff.application.dto;

import java.util.Date;

public record TransferDTO (Date transferDate, SimpleAccountDTO senderAccount, SimpleAccountDTO receiverAccount, Double amount,String transferType) {
}
