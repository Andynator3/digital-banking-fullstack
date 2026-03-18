package com.ecaj.dbankingbackend.repositories;

import com.ecaj.dbankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
