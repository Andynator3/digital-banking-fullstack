package com.ecaj.dbankingbackend.services;

import com.ecaj.dbankingbackend.dtos.*;
import com.ecaj.dbankingbackend.entities.*;
import com.ecaj.dbankingbackend.exceptions.CustomerNotFoundException;
import com.ecaj.dbankingbackend.mappers.CustomerMapperImpl;
import com.ecaj.dbankingbackend.repositories.AccountOperationRepository;
import com.ecaj.dbankingbackend.repositories.BankAccountRepository;
import com.ecaj.dbankingbackend.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    private CustomerMapperImpl dtoCustomerMapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        log.info("Saving new Customer");
        Customer customer=dtoCustomerMapper.fromCustomerDTO(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return dtoCustomerMapper.fromCustomer(savedCustomer);
    }

    @Override
    public List<CustomerDTO> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(customer -> dtoCustomerMapper.fromCustomer(customer))
                .collect(Collectors.toList());
        /*
        List<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer customer:customers){
            CustomerDTO customerDTO=dtoMapper.fromCustomer(customer);
            customerDTOS.add(customerDTO);
        }
        *
         */
        return customerDTOS;
    }
    @Override
    public CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not found"));
        return dtoCustomerMapper.fromCustomer(customer);
    }
    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        log.info("Saving new Customer");
        Customer customer=dtoCustomerMapper.fromCustomerDTO(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return dtoCustomerMapper.fromCustomer(savedCustomer);
    }
    @Override
    public void deleteCustomer(Long customerId){
        customerRepository.deleteById(customerId);
    }
    // Search customers by keyword
    @Override
    public List<CustomerDTO> searchCustomers(String keyword) {
        List<Customer> customers=customerRepository.searchCustomer(keyword);
        List<CustomerDTO> customerDTOS = customers.stream()
                .map(cust -> dtoCustomerMapper.fromCustomer(cust))
                .collect(Collectors.toList());
        return customerDTOS;
    }
}
