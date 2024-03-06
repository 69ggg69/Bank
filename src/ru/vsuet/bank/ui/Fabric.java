package ru.vsuet.bank.ui;

import ru.vsuet.bank.domain.BankAccount;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Fabric {
    private final Map<ComponentType, Component> componentMap;

    public Fabric() {
        this.componentMap = new HashMap<>();
    }
    public <T> Component build(int type, Service<T> service){
        try {
            ComponentType componentType = ComponentType.fromType(type);
            return componentMap.computeIfAbsent(componentType, (v)->{
                Component component;
                switch (v){
                    case MENU:
                        component = new Menu();
                    break;
                    case LIST:
                        component = new ListComponent<>(service);
                        break;
                    case ACCOUNT:
                        component = new AccountComponent<>(service);
                        break;
                    case CREATE_ACCOUNT:
                        component = new CreateComponent((Service<BankAccount>) service);
                        break;
                    case DELETE_ACCOUNT:
                        component = new DeleteComponent((Service<BankAccount>) service);
                        break;
                    case ADD_MONEY:
                        component = new AddMoneyComponent((Service<BankAccount>) service);
                        break;
                    case MINUS_MONEY:
                        component = new MinMoneyComponent((Service<BankAccount>) service);
                        break;
                    case TRANS_MONEY:
                        component = new TransMoneyComponent((Service<BankAccount>) service);
                    break;
                    default:
                        component = null;
                }
                return component;
                    });
        } catch (IllegalArgumentException e){
            return null;
        }
    }

}
