package com.example.app2;

public class App2Person {
    private String id;
    private String name;
    private int edad;

    public App2Person(String id, String name, int edad) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        
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
}
