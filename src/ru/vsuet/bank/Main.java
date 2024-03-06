package ru.vsuet.bank;

import ru.vsuet.bank.database.DataBaseAccountRepository;
import ru.vsuet.bank.database.DataBaseConnector;
import ru.vsuet.bank.domain.BankAccount;
import ru.vsuet.bank.repository.Repository;
import ru.vsuet.bank.ui.Component;
import ru.vsuet.bank.ui.Fabric;
import ru.vsuet.bank.ui.Service;
import ru.vsuet.bank.ui.ServiceAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBaseConnector connector = new DataBaseConnector();
        Repository<BankAccount> repository = new DataBaseAccountRepository(connector);
        Service<BankAccount> service = new ServiceAccount(repository);
        Fabric fabric = new Fabric();
        System.out.println("Enter 0 to exit menu\n");
        Scanner in = new Scanner(System.in);
            while (true){
                int command = in.nextInt();
                Component component = fabric.build(command, service);
                if (component == null){
                    return;
                }
                component.draw();
            }
       /*Repository<BankAccount> repository = new DataBaseAccountRepository(new DataBaseConnector());
        repository.list().forEach(System.out::println);

        System.out.println("==========================");
        System.out.println(repository.find(2L));*/


    }
}










