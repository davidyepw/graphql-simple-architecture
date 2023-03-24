package com.example.app2ux2;

public class App2Ux2Account {
   
    private String accountNum;
    private String accountType;
    private int balance;
    private String idPerson;

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
    public void setidPerson(String idPerson) {
        this.idPerson= idPerson;
    }
}
