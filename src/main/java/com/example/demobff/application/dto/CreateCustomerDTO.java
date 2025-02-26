package com.example.demobff.application.dto;

import java.util.List;

public record CreateCustomerDTO (String name , String segmentName, List<CustomerContactDTO> contacts,String cpf) {
}