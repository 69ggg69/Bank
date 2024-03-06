package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class AddMoneyComponent extends AbstractComponent<BankAccount>{
    protected AddMoneyComponent(Service<BankAccount> service) {
        super(ComponentType.ADD_MONEY, service);
    }

    @Override
    public void draw() {
        System.out.println("----Dai denga----");
        System.out.println("Vvedi id:");
        Scanner in = new Scanner(System.in);
        long id = in.nextLong();
        System.out.println("Vvedi denga:");
        BigDecimal amount = in.nextBigDecimal();
        service.addMoney(id, amount);
        System.out.println("you is cool");
    }
}
