package com.ecaj.dbankingbackend.repositories;

import com.ecaj.dbankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Search customers by keyword
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("select c from Customer c where c.name like :kw")
    List<Customer> searchCustomer(@Param("kw") String keyword);
}
