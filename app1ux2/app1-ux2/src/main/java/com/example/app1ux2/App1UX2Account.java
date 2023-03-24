package com.example.app1ux2;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class App1UX2Account {
    @JsonProperty("accountNum")
    private String accountNum;
    
    @JsonProperty("accountType")
    private String accountType;
    
    @JsonProperty("balance")
    private int balance;

    @JsonProperty("idPerson")
    private String idPerson;

    public static List<App1UX2Account> getByPersonId(String id) {
        System.out.println("***************String recibido: " + id + "*******************");
        
        return null;
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

    public void setAccountNum(String accountNum) {
        this.accountNum= accountNum;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public void setBalance(int balance) {
        this.balance= balance;
    }

}
