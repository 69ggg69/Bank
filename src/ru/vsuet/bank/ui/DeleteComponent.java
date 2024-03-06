package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.util.Scanner;

public class DeleteComponent extends AbstractComponent<BankAccount>{

    protected DeleteComponent(Service<BankAccount> service) {
        super(ComponentType.DELETE_ACCOUNT, service);
    }
    @Override
    public void draw() {
        System.out.println("----Delete account----");
        System.out.println("Enter account id for delete:");
        Scanner in = new Scanner(System.in);
        long id = in.nextLong();
        service.deleteCom(service.findCom(id));
        System.out.println("you is cool");
    }
}
