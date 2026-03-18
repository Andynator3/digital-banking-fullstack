package com.ecaj.dbankingbackend.exceptions;

public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
