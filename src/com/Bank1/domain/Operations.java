package com.Bank1.domain;

import java.math.BigDecimal;

public class Operations {

    public Operations() {
    }

    public static void addMoney(BankAccount bankAccount, BigDecimal money) {
        bankAccount.money = bankAccount.money.add(money);
    }

    public static void minMoney(BankAccount bankAccount, BigDecimal money) {
        if (bankAccount.money.compareTo(money) >= 0) {
            bankAccount.money = bankAccount.money.subtract(money);
        }
        else return;

    }

    public static void transfer(BankAccount sendAccount, BankAccount takeAccount, BigDecimal money) {
        if (sendAccount.money.compareTo(money) >= 0) {
            sendAccount.money = sendAccount.money.subtract(money);
            takeAccount.money = takeAccount.money.add(money);
        }
        else return;

    }
}
