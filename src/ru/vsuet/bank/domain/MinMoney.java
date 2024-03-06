package ru.vsuet.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MinMoney implements Command {
   private BankAccount account;
    private  BigDecimal amount;
    public MinMoney(BankAccount account,BigDecimal amount){
        this.account=account;
        this.amount=amount;
    }
    @Override
    public String execute() {
        if (account.amount.compareTo(amount) >= 0) {
            account.amount = account.amount.subtract(amount);
            return  toString();
        }
        else return null;
    }
    @Override
    public String loggir(){
        return "Minus money to: "+ account.getName()+" "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    };

}
