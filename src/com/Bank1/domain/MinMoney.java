package com.Bank1.domain;

import java.math.BigDecimal;
import java.util.List;

public class MinMoney implements Command {
   private BankAccount account;
    private  BigDecimal money;
    public MinMoney(BankAccount account,BigDecimal money){
        this.account=account;
        this.money=money;
    }

    @Override
    public String execute() {
        Operations.minMoney(account, money);
        return  this.toString();
    }
    @Override
    public String toString(){
        return "Дэнга ушла от  гения по имени: "
                +account.getName()
                +BankTime.getOperationTime();
    };


}
