package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.util.Scanner;

public class AccountComponent<T> extends AbstractComponent<T>{

    protected AccountComponent(Service<T> service) {
        super(ComponentType.ACCOUNT, service);
    }
    @Override
    public void draw() {
        System.out.println("----Account----");
        System.out.println("Enter number of id:");
        Scanner in = new Scanner(System.in);
        long giv = in.nextLong();
        T object = service.findCom(giv);
        System.out.println(object);
        System.out.println("---------------");
    }
}
