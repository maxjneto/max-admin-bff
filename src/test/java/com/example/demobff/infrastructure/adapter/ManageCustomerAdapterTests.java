package com.example.demobff.infrastructure.adapter;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;
import com.example.demobff.infrastructure.config.MicrosservicesInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ManageCustomerAdapterTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ManageCustomerAdapter manageCustomerAdapter;

    @Test
    void createCustomer_ReturnsCustomer_WhenSuccessful() {
        CreateCustomerDTO createCustomerDTO = new CreateCustomerDTO("John Doe", "Retail", List.of(), "123456789");
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(restTemplate.postForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer", createCustomerDTO, CustomerDTO.class))
                .thenReturn(customerDTO);

        CustomerDTO result = manageCustomerAdapter.createCustomer(createCustomerDTO);

        assertEquals(customerDTO, result);
    }

    @Test
    void createCustomer_ThrowsRestClientException_WhenServiceUnavailable() {
        CreateCustomerDTO createCustomerDTO = new CreateCustomerDTO("John Doe", "Retail", List.of(), "123456789");
        when(restTemplate.postForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer", createCustomerDTO, CustomerDTO.class))
                .thenThrow(new RestClientException("Service unavailable"));

        assertThrows(RestClientException.class, () -> manageCustomerAdapter.createCustomer(createCustomerDTO));
    }

    @Test
    void getCustomerById_ReturnsCustomer_WhenSuccessful() {
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/1", CustomerDTO.class))
                .thenReturn(customerDTO);

        CustomerDTO result = manageCustomerAdapter.getCustomerById(1L);

        assertEquals(customerDTO, result);
    }

    @Test
    void getCustomerById_ThrowsRestClientException_WhenServiceUnavailable() {
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/1", CustomerDTO.class))
                .thenThrow(new RestClientException("Service unavailable"));

        assertThrows(RestClientException.class, () -> manageCustomerAdapter.getCustomerById(1L));
    }

    @Test
    void getCustomerByName_ReturnsCustomer_WhenSuccessful() {
        CustomerDTO customerDTO = new CustomerDTO(1L, "John Doe", "Retail", List.of(), List.of());
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/name/John Doe", CustomerDTO.class))
                .thenReturn(customerDTO);

        CustomerDTO result = manageCustomerAdapter.getCustomerByName("John Doe");

        assertEquals(customerDTO, result);
    }

    @Test
    void getCustomerByName_ThrowsRestClientException_WhenServiceUnavailable() {
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/name/John Doe", CustomerDTO.class))
                .thenThrow(new RestClientException("Service unavailable"));

        assertThrows(RestClientException.class, () -> manageCustomerAdapter.getCustomerByName("John Doe"));
    }

    @Test
    void listCustomerContactsById_ReturnsContacts_WhenSuccessful() {
        CustomerContactDTO[] customerContacts = {new CustomerContactDTO("e-mail", "john.doe@example.com")};
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/contacts/1", CustomerContactDTO[].class))
                .thenReturn(customerContacts);

        List<CustomerContactDTO> result = manageCustomerAdapter.listCustomerContactsById(1L);

        assertEquals(List.of(customerContacts), result);
    }

    @Test
    void listCustomerContactsById_ThrowsRestClientException_WhenServiceUnavailable() {
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/contacts/1", CustomerContactDTO[].class))
                .thenThrow(new RestClientException("Service unavailable"));

        assertThrows(RestClientException.class, () -> manageCustomerAdapter.listCustomerContactsById(1L));
    }

    @Test
    void listCustomerDocumentsById_ReturnsDocuments_WhenSuccessful() {
        CustomerDocumentDTO[] customerDocuments = {new CustomerDocumentDTO("123", "Passport")};
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/documents/1", CustomerDocumentDTO[].class))
                .thenReturn(customerDocuments);

        List<CustomerDocumentDTO> result = manageCustomerAdapter.listCustomerDocumentsById(1L);

        assertEquals(List.of(customerDocuments), result);
    }

    @Test
    void listCustomerDocumentsById_ThrowsRestClientException_WhenServiceUnavailable() {
        when(restTemplate.getForObject(MicrosservicesInfo.CUSTOMERS.getUrl() + "/customer/documents/1", CustomerDocumentDTO[].class))
                .thenThrow(new RestClientException("Service unavailable"));

        assertThrows(RestClientException.class, () -> manageCustomerAdapter.listCustomerDocumentsById(1L));
    }

}
