package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.math.BigDecimal;
import java.util.Scanner;

public class CreateComponent extends AbstractComponent<BankAccount> {
    protected CreateComponent(Service<BankAccount> service) {
        super(ComponentType.CREATE_ACCOUNT, service);
    }
    @Override
    public void draw() {
        System.out.println("----Create account----");
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter your id:");
        Long id = in.nextLong();
        System.out.println("Enter name account:");
        String name = in.nextLine();
        System.out.println("Polozhi money");
        BigDecimal amount = in.nextBigDecimal();
        service.addCom(new BankAccount(id, name, amount));
        System.out.println("you is cool");
    }
}
