package com.Bank1.domain;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

public class Switch extends Operations{
    private Command popolnenie;
    private Command snatie;
    private Command perevod;
    public Switch(Command popolnenie, Command snatie, Command perevod){
        this.popolnenie=popolnenie;
        this.snatie=snatie;
        this.perevod=perevod;
    }
    public String add(){
       return  popolnenie.execute();

    }
    public String min(){
       return snatie.execute();
    }
    public String transf(){
       return perevod.execute();

    }
}





