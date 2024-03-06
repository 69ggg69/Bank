package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class TransMoneyComponent extends AbstractComponent<BankAccount> {

    protected TransMoneyComponent(Service<BankAccount> service) {
        super(ComponentType.TRANS_MONEY, service);
    }

    @Override
    public void draw() {
        System.out.println("----Perevod money----");
        System.out.println("Vvedi id account source:");
        Scanner in = new Scanner(System.in);
        long id1 = in.nextLong();
        System.out.println("Vvedi id account target:");
        long id2 = in.nextLong();
        System.out.println("Vvedi denga:");
        BigDecimal amount = in.nextBigDecimal();
        service.transfer(id1, id2, amount);
        System.out.println("you is cool");
    }
}
