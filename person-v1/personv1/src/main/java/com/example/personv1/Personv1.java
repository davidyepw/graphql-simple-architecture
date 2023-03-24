package com.example.personv1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class Personv1 {
    
    private String id;
    private String name;
    private int edad;

    public Personv1(String id, String name, int edad) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        
    }

    private static List<Personv1> personList = Arrays.asList(
        new Personv1("00000000", "Miguel Tapia", 58),
        new Personv1("11111111", "Jorge Gonzales", 58),
        new Personv1("22222222", "Claudio Narea ", 57)
    );
    
    public static Personv1 getById(String id) {
        
        List<Personv1> dataIterate = personList;
        Iterator<Personv1> iterator = dataIterate.iterator();
        
        while(iterator.hasNext()){
            Personv1 dataIterated = iterator.next();
            
            if (dataIterated.getId().equals(id)) {
                return dataIterated;
            }
        }
        return null;
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
