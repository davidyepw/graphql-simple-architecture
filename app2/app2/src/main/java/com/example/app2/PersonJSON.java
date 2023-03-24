package com.example.app2;

public class PersonJSON {
    private String id;
    private int edad;
    //private List<Addresses> addresses;
    private String name; 

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getEdad() {
        return edad;
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
}
