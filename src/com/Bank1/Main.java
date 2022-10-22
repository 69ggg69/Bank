package com.Bank1;
import com.Bank1.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(1, "Vatutin K.R.", 6, BigDecimal.valueOf(6557.87));
        BankAccount bankAccount2=new BankAccount(2, "Volkov M.A.", 7, BigDecimal.valueOf(6757658.987));
        System.out.println(bankAccount1);
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(bankAccount1);
        Command add=new AddMoney(bankAccount1, BigDecimal.valueOf(786.979));
        Command min=new MinMoney(bankAccount1, BigDecimal.valueOf(6609.99));
        Command transfer=new Transfer(bankAccount1, bankAccount2, BigDecimal.valueOf(701.6));
        Switch s = new Switch(add, min, transfer);
        System.out.println(s.add());
        System.out.println(s.min());
        System.out.println(s.transf());
        System.out.println(bankAccount1);
        System.out.println(bankAccount2);



       // for (Object bankAccount.BankAccount){
         //   if (o instanceof BankAccount) ;
           // ((BankAccount) o).getMoney(); чекнуть про джинерики
        }

    }







