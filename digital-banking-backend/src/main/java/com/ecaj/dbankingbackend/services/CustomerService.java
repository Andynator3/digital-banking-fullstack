package com.ecaj.dbankingbackend.services;

import com.ecaj.dbankingbackend.dtos.*;
import com.ecaj.dbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> listCustomers();
    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long customerId);
    List<CustomerDTO> searchCustomers(String keyword);
}
