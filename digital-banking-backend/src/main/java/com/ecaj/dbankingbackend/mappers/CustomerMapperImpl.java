package com.ecaj.dbankingbackend.mappers;

import com.ecaj.dbankingbackend.dtos.CustomerDTO;
import com.ecaj.dbankingbackend.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapperImpl {
    // Search customers by keyword
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO=new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        /* customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());*/
        return  customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDTO,customer);
        return  customer;
    }

}
