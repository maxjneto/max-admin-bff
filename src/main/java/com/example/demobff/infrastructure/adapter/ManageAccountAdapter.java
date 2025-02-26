package com.example.demobff.infrastructure.adapter;

import com.example.demobff.application.dto.*;
import com.example.demobff.application.port.output.ManageAccountOutput;
import com.example.demobff.infrastructure.config.MicrosservicesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ManageAccountAdapter implements ManageAccountOutput {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<AccountWithdrawalDTO> listWithdrawalsByAccountNumber(String accountNumber) {
        try{
            AccountWithdrawalDTO[] accountWithdrawals = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/withdrawal/" + accountNumber, AccountWithdrawalDTO[].class);
            if(accountWithdrawals != null) return List.of(accountWithdrawals);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
        return List.of();
    }

    @Override
    public List<AccountDepositDTO> listDepositsByAccountNumber(String accountNumber) {
        try{
            AccountDepositDTO[] accountDeposits = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/deposit/" + accountNumber, AccountDepositDTO[].class);
            if(accountDeposits != null) return List.of(accountDeposits);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
        return List.of();
    }

    @Override
    public List<TransferDTO> listAllTransfersByAccountId(Long id) {
        try{
            TransferDTO[] transfers = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/transfer/all/" + id, TransferDTO[].class);
            if(transfers != null) return List.of(transfers);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
        return List.of();
    }

    @Override
    public List<TransferDTO> listSentTransfersByAccountId(Long id) {
        try{
            TransferDTO[] transfers = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/transfer/sent/" + id, TransferDTO[].class);
            if(transfers != null) return List.of(transfers);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
        return List.of();
    }

    @Override
    public List<TransferDTO> listReceivedTransfersByAccountId(Long id) {
        try{
            TransferDTO[] transfers = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/transfer/received/" + id, TransferDTO[].class);
            if(transfers != null) return List.of(transfers);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
        return List.of();
    }

}
