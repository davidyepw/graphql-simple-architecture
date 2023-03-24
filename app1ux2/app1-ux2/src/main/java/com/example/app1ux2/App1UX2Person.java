package com.example.app1ux2;

import java.util.List;

public class App1UX2Person {
    
    private String id;
    private String name;
    private int edad;
    private List<App1UX2Account> accountaaas;
 
    public App1UX2Person(String id, String name, int edad,List<App1UX2Account> accountaaas) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.accountaaas = accountaaas;
        
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getEdad() {
        return edad;
    }

    //the name of the getter sets the value of the returned json field "getAccounts" returns accounts, "getAccountaaas" returns accountaaas
    public List<App1UX2Account> getAccounts()
    {
        return accountaaas;
    }

    public void setId(String id) {
        this.id=id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setEdad(int edad) {
        this.edad =edad;
    }

    public void setAccountaaas(List<App1UX2Account> accountaaas)
    {
        this.accountaaas = accountaaas;
    }

}
