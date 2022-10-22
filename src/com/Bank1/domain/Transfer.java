package com.Bank1.domain;

import java.math.BigDecimal;

public class Transfer implements Command {
    private BankAccount sendAcc;
    private BankAccount takeAcc;
    private BigDecimal money;
    public Transfer(BankAccount sendAcc, BankAccount takeAcc, BigDecimal money){
        this.sendAcc=sendAcc;
        this.takeAcc=takeAcc;
        this.money=money;
    }
    public String execute(){
        Operations.transfer(sendAcc, takeAcc, money);
        return this.toString();
    }
    public String toString(){
        return "Дэнга идет к гения  по имени: "
                +sendAcc.getName()
                +"к гению похуже по имени: "+takeAcc.getName()
                +BankTime.getOperationTime();
    };
}
