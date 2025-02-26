package com.example.demobff.domain.service;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;
import com.example.demobff.application.port.output.ManageCustomerOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManageCustomerServiceTests {

    @Mock
    private ManageCustomerOutput manageCustomerOutput;

    @InjectMocks
    private ManageCustomerService manageCustomerService;


    @Test
    void createCustomer_ReturnsCustomer_WhenSuccessful() {
        CreateCustomerDTO createCustomerDTO = new CreateCustomerDTO("John Doe", "Retail", List.of(), "123456789");
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(manageCustomerOutput.createCustomer(createCustomerDTO)).thenReturn(customerDTO);

        CustomerDTO result = manageCustomerService.createCustomer(createCustomerDTO);

        assertEquals(customerDTO, result);
    }

    @Test
    void getCustomerById_ReturnsCustomer_WhenSuccessful() {
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(manageCustomerOutput.getCustomerById(1L)).thenReturn(customerDTO);

        CustomerDTO result = manageCustomerService.getCustomerById(1L);

        assertEquals(customerDTO, result);
    }

    @Test
    void getCustomerByName_ReturnsCustomer_WhenSuccessful() {
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(manageCustomerOutput.getCustomerByName("John Doe")).thenReturn(customerDTO);

        CustomerDTO result = manageCustomerService.getCustomerByName("John Doe");

        assertEquals(customerDTO, result);
    }

    @Test
    void listCustomerContactsById_ReturnsContacts_WhenSuccessful() {
        CustomerContactDTO contactDTO = new CustomerContactDTO("e-mail", "john.doe@example.com");
        when(manageCustomerOutput.listCustomerContactsById(1L)).thenReturn(List.of(contactDTO));

        List<CustomerContactDTO> result = manageCustomerService.listCustomerContactsById(1L);

        assertEquals(List.of(contactDTO), result);
    }

    @Test
    void listCustomerDocumentsById_ReturnsDocuments_WhenSuccessful() {
        CustomerDocumentDTO documentDTO = new CustomerDocumentDTO("12345", "Passport");
        when(manageCustomerOutput.listCustomerDocumentsById(1L)).thenReturn(List.of(documentDTO));

        List<CustomerDocumentDTO> result = manageCustomerService.listCustomerDocumentsById(1L);

        assertEquals(List.of(documentDTO), result);
    }

}
