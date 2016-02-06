package com.example.config.spring;

import org.jooq.Transaction;

import org.springframework.transaction.TransactionStatus;

public class SpringTransaction implements Transaction {
    public final TransactionStatus tx;

    public SpringTransaction(TransactionStatus tx) {
        this.tx = tx;
    }
}