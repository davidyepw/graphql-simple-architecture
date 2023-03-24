package com.example.app2ux1;

import java.io.IOException;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App2UX1Person {
    private String id;
    private String name;
    private int edad;

    public App2UX1Person(String id, String name, int edad) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        
    }

    public static App2UX1Person getById(String id) {
        
        //String uriPerson = "http://localhost:8080/getperson?name="+id;
        String uriPerson = "http://host.docker.internal:8080/getperson?name="+id;
                
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Created RestTemplate object");
        String result = restTemplate.exchange(uriPerson, HttpMethod.GET, null, String.class).getBody();
        System.out.println("post getForObject");
  
        System.out.println("setted id: "+ id);

        System.out.println("result contiene: "+ result.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            PersonJSON personJson = mapper.readValue(result.toString(), PersonJSON.class);
            System.out.println("valor obj.getname: "+personJson.getName());
            //namePxA = personJson.getName();
            //edadPxA = personJson.getEdad();

            App2UX1Person app2ux1person = new App2UX1Person(id,personJson.getName(),personJson.getEdad());
            System.out.println("app2ux1person content found:"+ app2ux1person); 
            System.out.println("name in app2ux1person objetc found:" + app2ux1person.getName());
            
            return app2ux1person;
        }
        catch (IOException e) {
            e.printStackTrace();
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
