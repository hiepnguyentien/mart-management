package com.hiep.mart.service;

public interface Finance {
    void viewBalance();
    void viewTransactionHistory();
    void viewTransactionDetail(Long transactionId);
    void viewTransactionStatus(Long transactionId);
    void viewTransactionInvoice(Long transactionId);
    void viewTransactionReceipt(Long transactionId);
}
