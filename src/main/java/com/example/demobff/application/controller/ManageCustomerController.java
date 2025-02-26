package com.example.demobff.application.controller;

import com.example.demobff.application.dto.CreateCustomerDTO;
import com.example.demobff.application.dto.CustomerContactDTO;
import com.example.demobff.application.dto.CustomerDTO;
import com.example.demobff.application.dto.CustomerDocumentDTO;
import com.example.demobff.domain.service.ManageCustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManageCustomerController {

    private static final Logger logger = LogManager.getLogger(ManageCustomerController.class);

    @Autowired
    private ManageCustomerService manageCustomerService;

    @PostMapping("/cliente")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Validated CreateCustomerDTO customer) {
        CustomerDTO createdCustomer = manageCustomerService.createCustomer(customer);
        logger.info("Created account with name: " + customer.name());
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
        CustomerDTO customer = manageCustomerService.getCustomerById(id);
        logger.info("Found customer with id: " + id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/cliente/name/{nome}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String nome) {
        CustomerDTO customer = manageCustomerService.getCustomerByName(nome);
        logger.info("Found customer with name: " + nome);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/cliente/contatos/{id}")
    public ResponseEntity<List<CustomerContactDTO>> listCustomerContactsById(@PathVariable Long id) {
        List<CustomerContactDTO> customerContacts = manageCustomerService.listCustomerContactsById(id);
        logger.info("Recovered the contacts of customer with id: " + id);
        return ResponseEntity.ok(customerContacts);
    }

    @GetMapping("/cliente/documentos/{id}")
    public ResponseEntity<List<CustomerDocumentDTO>> listCustomerDocumentsById(@PathVariable Long id) {
        List<CustomerDocumentDTO> customerDocuments = manageCustomerService.listCustomerDocumentsById(id);
        logger.info("Recovered the documents of customer with id: " + id);
        return ResponseEntity.ok(customerDocuments);
    }

}
