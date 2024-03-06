package ru.vsuet.bank.ui;

import java.util.Arrays;

public enum ComponentType {
    MENU(0, "menu"),
    LIST(1, " - accounts list"),
    ACCOUNT(2, " - get account by id"),
    CREATE_ACCOUNT(3, " - create new account"),
    DELETE_ACCOUNT(4, " - delete account"),
    ADD_MONEY(5, " - add money"),
    MINUS_MONEY(6, " - minus money"),
    TRANS_MONEY(7, " - transfer money");

    private final int type;
    private final String comment;

    ComponentType(int type, String comment) {
        this.type = type;
        this.comment = comment;
    }
    public int getType(){
    return type;
    }

    public String getComment() {
        return comment;
    }
    public static ComponentType fromType(int type){
        return Arrays.stream(values()).filter(v->v.type==type).findFirst().
                orElseThrow(() -> new IllegalArgumentException("No component with type: " + type));
    }
}

