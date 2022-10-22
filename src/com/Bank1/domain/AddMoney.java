package com.Bank1.domain;
import java.math.BigDecimal;
public class AddMoney implements Command {

    private BankAccount account;
    private BigDecimal money;
    public AddMoney(BankAccount account,BigDecimal money){
       this.account = account;
       this.money = money;
    }
    @Override
    public String execute() {
        Operations.addMoney(account,money);
        return toString();
    }

    @Override
   public String toString(){
       return "Дэнга пришла к гению по имени: "
               +account.getName()
               +BankTime.getOperationTime();
    };



}
