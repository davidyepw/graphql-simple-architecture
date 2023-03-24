package com.example.app1ux1;

import java.util.List;

public class App1UX1Person {
    private String id;
    private String name;
    private int edad;
    //@OneToMany(mappedBy = "idPerson")
    private List<App1UX1Address> addresses;
 
    public App1UX1Person(String id, String name, int edad,List<App1UX1Address> addresses) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.addresses = addresses;
        
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

    public List<App1UX1Address> getAddress()
    {
        return addresses;
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

    public void setAddress(List<App1UX1Address> addresses)
    {
        this.addresses = addresses;
    }

}
