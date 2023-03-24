package com.example.accountv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Accountv1 {
    
    private String accountNum;
    private String accountType;
    private int balance;
    private String idPerson;

    public Accountv1(String accountNum, String accountType, int balance, String idPerson) {

        this.accountNum = accountNum;
        this.accountType = accountType;
        this.balance = balance;
        this.idPerson = idPerson;
    
    }

    private static List<Accountv1> addressList = Arrays.asList(
        new Accountv1("193-000-001", "ahorro", 100,"00000000"),
        new Accountv1("193-000-002", "ahorro", 200,"11111111"),
        new Accountv1("193-000-003", "corriente", 300,"11111111"),
        new Accountv1("193-000-004", "corriente", 400,"22222222")
    );

    public static List<Accountv1> getByPersonId(String id) {
        //System.out.println("***************String recibido: " + id + "*******************");
        List<Accountv1> dataIterate = addressList;
        List<Accountv1> personAccountList = new ArrayList<>();
        Iterator<Accountv1> iterator = dataIterate.iterator();
        while(iterator.hasNext()){
            Accountv1 dataIterated = iterator.next();
            //System.out.println("Iterando Account: " + dataIterated.accountNum.toString());
            if (dataIterated.getIdPerson().equals(id)) {
                //System.out.println("Match Account con idPerson");
                personAccountList.add(dataIterated);
            }
            
        }
        return personAccountList;
    }

    public String getAccountNum() {
        return accountNum;
    }
    public String getAccountType() {
        return accountType;
    }
    public int getBalance() {
        return balance;
    }
    public String getIdPerson() {
        return idPerson;
    }
}
