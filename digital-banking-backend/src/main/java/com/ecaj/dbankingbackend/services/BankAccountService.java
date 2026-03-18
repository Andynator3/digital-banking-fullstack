package com.ecaj.dbankingbackend.services;

import com.ecaj.dbankingbackend.dtos.*;
import com.ecaj.dbankingbackend.exceptions.BalanceNotSufficientException;
import com.ecaj.dbankingbackend.exceptions.BankAccountNotFoundException;
import com.ecaj.dbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;
public interface BankAccountService {
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
    List<BankAccountDTO> bankAccountList();
    List<AccountOperationDTO> accountHistory(String accountId);
    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

}
