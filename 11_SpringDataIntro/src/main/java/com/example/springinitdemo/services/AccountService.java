package com.example.springinitdemo.services;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal amount, Long id);

    void depositMoney(BigDecimal amount, Long id);

    void transferMoney(Long accountFrom, Long accountTo, BigDecimal amount);
}
