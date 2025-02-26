package com.example.demobff.application.port.input;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;

import java.util.List;

public interface ManageCustomerUseCase {

    CustomerDTO createCustomer(CreateCustomerDTO customer);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO getCustomerByName(String name);

    List<CustomerContactDTO> listCustomerContactsById(Long id);

    List<CustomerDocumentDTO> listCustomerDocumentsById(Long id);

}
