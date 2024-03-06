package ru.vsuet.bank.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transfer implements Command {
    private BankAccount sendAcc;
    private BankAccount takeAcc;
    private BigDecimal amount;
    public Transfer(BankAccount sendAcc, BankAccount takeAcc, BigDecimal amount){
        this.sendAcc=sendAcc;
        this.takeAcc=takeAcc;
        this.amount=amount;
    }
    @Override
    public String execute(){
        if (sendAcc.amount.compareTo(amount) >= 0) {
            sendAcc.amount = sendAcc.amount.subtract(amount);
            takeAcc.amount = takeAcc.amount.add(amount);
            return toString();
        }
        else return null;
    }
    @Override
    public String loggir(){
        return "Transfer from: " + sendAcc.getName()+
                " to: "+ takeAcc.getName()+" "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    };
}
