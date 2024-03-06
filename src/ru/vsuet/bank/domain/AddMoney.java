package ru.vsuet.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddMoney implements Command {
    private BankAccount account;
    private BigDecimal amount;

    public AddMoney(BankAccount account, BigDecimal amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public String execute() {
        account.amount = account.amount.add(amount);
        return toString();
    }

    @Override
    public String loggir() {
        return "Add money to: " + account.getName() +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}
