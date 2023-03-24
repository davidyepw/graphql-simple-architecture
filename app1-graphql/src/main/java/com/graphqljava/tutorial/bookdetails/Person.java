package com.graphqljava.tutorial.bookdetails;

import java.io.IOException;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {

    private String id;
    private String name;
    private int edad;
    

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
        this.edad=edad;
    }
    


    public static Person getById(String id) {

        //System.out.println("inside Person getById");
    
        //String uriPerson = "http://localhost:8080/getperson?name="+id;
        String uriPerson = "http://host.docker.internal:8080/getperson?name="+id;

        RestTemplate restTemplate = new RestTemplate();
        //System.out.println("Created RestTemplate object");
        String result = restTemplate.exchange(uriPerson, HttpMethod.GET, null, String.class).getBody();
        //System.out.println("post getForObject");
        //System.out.println("setted id: "+ id);
        //System.out.println("result contiene: "+ result.toString());
        ObjectMapper mapper = new ObjectMapper();
        //Person personObj = new Person("789","Nombre Apellido",18);
        try {
            
            Person personJson = mapper.readValue(result.toString(), Person.class);
            ////System.out.println("valor personObj.getname: "+personJson.getName());
            return personJson;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        

        return null;

    }
}

 
