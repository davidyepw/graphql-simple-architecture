package com.example.app2;

public class AccountJSON {
    private String accountNum;
    private String accountType;
    private int balance;
    //private String idPerson;

    public String getAccountNum() {
        return accountNum;
    }
    public String getAccountType() {
        return accountType;
    }
    public int getBalance() {
        return balance;
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
