package ru.vsuet.bank.ui;

public class ListComponent<T> extends AbstractComponent<T>{

    protected ListComponent(Service<T> service) {
        super(ComponentType.LIST, service);
    }

    @Override
    public void draw() {
        System.out.println("----Accounts list----");
        service.getAll().forEach(System.out::println);
        System.out.println("---------------------");

    }
}
