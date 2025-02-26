package com.example.demobff.application.controller;

import com.example.demobff.application.dto.*;
import com.example.demobff.domain.service.ManageAccountService;
import com.example.demobff.domain.service.ManageCustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManageCustomerControllerTests {

    @InjectMocks
    private ManageCustomerController manageCustomerController;

    @Mock
    private ManageCustomerService manageCustomerService;

    @Test
    void createCustomerReturnOk() {
        CreateCustomerDTO mockCustomer = new CreateCustomerDTO("John Doe", "Tailor", List.of(), "123456789");
        ResponseEntity<CustomerDTO> response = manageCustomerController.createCustomer(mockCustomer);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void getCustomerByIdReturnOk() {
        CustomerDTO customerMock = new CustomerDTO(1L,"John Doe","Tailor",List.of(),List.of());
        when(manageCustomerService.getCustomerById(1L)).thenReturn(customerMock);

        ResponseEntity<CustomerDTO> response = manageCustomerController.getCustomerById(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(customerMock);
    }

    @Test
    void getCustomerByNameReturnOk() {
        CustomerDTO customerMock = new CustomerDTO(1L,"John Doe","Tailor",List.of(),List.of());
        when(manageCustomerService.getCustomerByName("John Doe")).thenReturn(customerMock);

        ResponseEntity<CustomerDTO> response = manageCustomerController.getCustomerByName("John Doe");

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(customerMock);
    }

    @Test
    void listCustomerContactsByIdReturnOk() {
        List<CustomerContactDTO> contactMock = List.of(new CustomerContactDTO("e-mail","johndoe@email.com"));
        when(manageCustomerService.listCustomerContactsById(1L)).thenReturn(contactMock);

        ResponseEntity<List<CustomerContactDTO>> response = manageCustomerController.listCustomerContactsById(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(contactMock);
    }

    @Test
    void listCustomerDocumentsByIdReturnOk() {
        List<CustomerDocumentDTO> documentMock = List.of(new CustomerDocumentDTO("12345678900","CPF"));
        when(manageCustomerService.listCustomerDocumentsById(1L)).thenReturn(documentMock);

        ResponseEntity<List<CustomerDocumentDTO>> response = manageCustomerController.listCustomerDocumentsById(1L);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(documentMock);
    }


}
