package com.example.demobff.infrastructure.adapter;

import com.example.demobff.application.dto.AccountDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.port.output.GetAccountOutput;
import com.example.demobff.domain.exception.EntityNotFoundException;
import com.example.demobff.infrastructure.config.MicrosservicesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GetAccountAdapter implements GetAccountOutput {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<AccountDTO> listAccountsByCustomerId(Long id) {
        try{
            CustomerDTO customer = restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/" + id, CustomerDTO.class);
            if(customer != null){
                AccountDTO[] accounts = restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/account/" + id, AccountDTO[].class);
                if(accounts != null) return List.of(accounts);
            }else{
                throw new EntityNotFoundException("Cliente não encontrado");
            }
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar algum dos microsservicos.");
        }
        return List.of();
    }

    @Override
    public AccountDTO getAccountByNumber(String accountNumber) {
        try{
            return restTemplate.getForObject(MicrosservicesInfo.TRANSFERS.getUrl() + "/account/number/" + accountNumber, AccountDTO.class);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de transferencias");
        }
    }
}
