package com.Bank1.domain;

import java.util.GregorianCalendar;

public class BankTime {
    public static String getOperationTime(){
        return  "Трахание охлаждено в "+ new GregorianCalendar().getTime().toString();
    }
}
