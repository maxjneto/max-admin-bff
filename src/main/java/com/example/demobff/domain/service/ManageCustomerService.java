package com.example.demobff.domain.service;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;
import com.example.demobff.application.port.input.ManageCustomerUseCase;
import com.example.demobff.application.port.output.ManageCustomerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageCustomerService implements ManageCustomerUseCase {

    @Autowired
    private ManageCustomerOutput customerOutput;

    @Override
    public CustomerDTO createCustomer(CreateCustomerDTO customer) {
        return customerOutput.createCustomer(customer);
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerOutput.getCustomerById(id);
    }

    @Override
    public CustomerDTO getCustomerByName(String name) {
        return customerOutput.getCustomerByName(name);
    }

    @Override
    public List<CustomerContactDTO> listCustomerContactsById(Long id) {
        return customerOutput.listCustomerContactsById(id);
    }

    @Override
    public List<CustomerDocumentDTO> listCustomerDocumentsById(Long id) {
        return customerOutput.listCustomerDocumentsById(id);
    }
}
