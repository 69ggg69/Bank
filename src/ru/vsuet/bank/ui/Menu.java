package ru.vsuet.bank.ui;

import java.util.Arrays;

public class Menu extends AbstractComponent<Void>{

    public Menu() {
        super(ComponentType.MENU, null);
    }

    @Override
    public void draw() {
        System.out.println("*** WELCOME TO THE BANK MMM ***");
        System.out.println("*** MENU ***");
        Arrays.stream(ComponentType.values()).map(v->v.getType()
        + " " + v.getComment()).forEach(System.out::println);
        System.out.println("Push 9 for exit\n");

    }
}
