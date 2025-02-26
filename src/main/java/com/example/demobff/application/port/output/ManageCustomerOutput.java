package com.example.demobff.application.port.output;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;

import java.util.List;

public interface ManageCustomerOutput {

    CustomerDTO createCustomer(CreateCustomerDTO customer);

    CustomerDTO getCustomerById(Long id);

    CustomerDTO getCustomerByName(String name);

    List<CustomerContactDTO> listCustomerContactsById(Long id);

    List<CustomerDocumentDTO> listCustomerDocumentsById(Long id);

}
