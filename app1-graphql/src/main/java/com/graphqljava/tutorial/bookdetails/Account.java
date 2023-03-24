package com.graphqljava.tutorial.bookdetails;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Account {

    private String accountNum;
    private String accountType;
    private int balance;

    public static List<Account> getAcountByPersonId (String idPersona){
        
        
        //String uriAccount = "http://localhost:8083/bs-getaccount?name="+idPersona;
        String uriAccount = "http://host.docker.internal:8083/bs-getaccount?name="+idPersona;
        RestTemplate restTemplateAccount = new RestTemplate();
               
        ResponseEntity<List<Account>> response =
        restTemplateAccount.exchange(
            uriAccount,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Account>>() {}
          ); 
          //System.out.println("valor de response.getBody:"+  response.getBody().toString());
        List<Account> accountsList = response.getBody();
        //accountsPxA=(accountsList.stream().collect(Collectors.toList()));

        System.out.println("size de accountsList:"+  accountsList.size());
        return accountsList;
        
        
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
    public void setAccountNum(String accountNum) {
        this.accountNum=accountNum;
    }

    public void setAccountType(String accountType) {
        this.accountType=accountType;
    }
    public void getBalance(int balance) {
        this.balance=balance;
    }
    
}