package com.Bank1.domain;
import java.math.BigDecimal;
public class BankAccount{
    private int id;
    private String name;
    private int num;
    protected BigDecimal money;
   public BankAccount(int id, String name, int num, BigDecimal money) {
        this.id = id;
        this.name = name;
        this.num=num;
        this.money=money;
    }
    public BankAccount() {
    }
    @Override
    public String toString() {
        return "id:" + " " + id + " " + "Name" + " " + name + " " + "Schet" + " " + num + " " + "YourDenga:" + " "+ money;
    }

    public String getName() {
        return name;
    }
    /*public void minus(BigDecimal money) {
        if (money.compareTo(money) > 0) {
            this.money = this.money.subtract(money);
        }
    }*/

   /* public BigDecimal getMoney(){
        return money;
    }*/


}
   /*@Override
    public BankAccount find(long id) {
        return null;
    }

    @Override
    public void delete(BankAccount bankAccount) {
        bankAccount.remove(bankAccount);
    }

    @Override
    public List<BankAccount> list() {
        return null;
    }*/






