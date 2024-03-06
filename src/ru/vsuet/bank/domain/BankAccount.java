package ru.vsuet.bank.domain;

import java.math.BigDecimal;

public class BankAccount {
    private Long id;
    private String name;
    protected BigDecimal amount;

    public BankAccount(Long id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }


    public static BankAccount of(Long id, String name, BigDecimal amount) {
        return new BankAccount(id, name, amount);
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}







