package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.List;

public interface Service<T> {
    void transfer(Long source, Long target, BigDecimal amount);
    List<BankAccount> getAll();
    void addMoney(Long source, BigDecimal amount);
    void minMoney(Long source, BigDecimal amount);
    T findCom(Long id);
    void deleteCom(BankAccount target);
    void addCom(T source);
}
