package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class MinMoneyComponent extends AbstractComponent<BankAccount> {

    protected MinMoneyComponent(Service<BankAccount> service) {
        super(ComponentType.MINUS_MONEY, service);
    }
    @Override
    public void draw() {
        System.out.println("----Minus money----");
        System.out.println("Vvedi id:");
        Scanner in = new Scanner(System.in);
        long id = in.nextLong();
        System.out.println("Vvedi money:");
        BigDecimal amount = in.nextBigDecimal();
        service.addMoney(id, amount);
        System.out.println("you is cool");
    }
}
