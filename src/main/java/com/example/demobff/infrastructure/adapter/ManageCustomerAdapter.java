package com.example.demobff.infrastructure.adapter;

import com.example.demobff.application.dto.*;
import com.example.demobff.application.port.output.ManageCustomerOutput;
import com.example.demobff.infrastructure.config.MicrosservicesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ManageCustomerAdapter implements ManageCustomerOutput {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CustomerDTO createCustomer(CreateCustomerDTO customer) {
        try{
            return restTemplate.postForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer", customer, CustomerDTO.class);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de clientes");
        }
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        try{
            return restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/" + id, CustomerDTO.class);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de clientes");
        }
    }

    @Override
    public CustomerDTO getCustomerByName(String name) {
        try{
            return restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/name/" + name, CustomerDTO.class);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de clientes");
        }
    }

    @Override
    public List<CustomerContactDTO> listCustomerContactsById(Long id) {
        try{
            CustomerContactDTO[] customerContacts = restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/contacts/" + id, CustomerContactDTO[].class);
            if(customerContacts != null) return List.of(customerContacts);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de clientes");
        }
        return List.of();
    }

    @Override
    public List<CustomerDocumentDTO> listCustomerDocumentsById(Long id) {
        try{
            CustomerDocumentDTO[] customerDocuments = restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/documents/" + id, CustomerDocumentDTO[].class);
            if(customerDocuments != null) return List.of(customerDocuments);
        } catch (RestClientException e) {
            throw new RestClientException("Nao foi possivel acessar o microsservico de clientes");
        }
        return List.of();
    }
}
