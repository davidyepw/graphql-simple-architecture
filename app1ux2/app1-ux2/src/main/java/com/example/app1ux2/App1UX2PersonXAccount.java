package com.example.app1ux2;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App1UX2PersonXAccount {
    
    public static App1UX2Person getById(String id) {

        final String idPxA;
        final String namePxA;
        final int edadPxA;
        final List<App1UX2Account> accountsPxA;

        String uriAccount = "http://host.docker.internal:8083/bs-getaccount?name="+id;
        //String uriAccount = "http://localhost:8083/bs-getaccount?name="+id;
        RestTemplate restTemplateAccount = new RestTemplate();
                
        ResponseEntity<List<App1UX2Account>> response =
        restTemplateAccount.exchange(
            uriAccount,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<App1UX2Account>>() {}
          );
          System.out.println("valor de response.getBody:"+  response.getBody().toString());
        List<App1UX2Account> accountsList = response.getBody();
        accountsPxA=(accountsList.stream().collect(Collectors.toList()));
        System.out.println("valor de accountsPxA:" + accountsPxA.iterator().next().getAccountNum().toString());
        
        String uriPerson = "http://host.docker.internal:8080/getperson?name="+id;
        //String uriPerson = "http://localhost:8080/getperson?name="+id;

        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Created RestTemplate object");
        String result = restTemplate.exchange(uriPerson, HttpMethod.GET, null, String.class).getBody();
        System.out.println("post getForObject");
  
        idPxA = id;

        System.out.println("setted id: "+ id);

        System.out.println("result contiene: "+ result.toString());
        ObjectMapper mapper = new ObjectMapper();
        try {
            PersonJSON personJson = mapper.readValue(result.toString(), PersonJSON.class);
            System.out.println("valor obj.getname: "+personJson.getName());
            namePxA = personJson.getName();
            edadPxA = personJson.getEdad();

            App1UX2Person personXAccount = new App1UX2Person(idPxA,namePxA,edadPxA,accountsPxA);
            System.out.println("account list content found:"+ accountsPxA.size()); 
            System.out.println("account in Person objetc found:" + personXAccount.getAccounts().iterator().next().toString());
            
            return personXAccount;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        

        return null;
    

    }

}
