package com.example.app1ux1;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App1UX1PersonXAddress {

    public static App1UX1Person getById(String id) {

        final String idPxA;
        final String namePxA;
        final int edadPxA;
        final List<App1UX1Address> addressesPxA;

        //String uriAddress = "http://localhost:8082/getaddress?name="+id;
        String uriAddress = "http://host.docker.internal:8082/getaddress?name="+id;
        RestTemplate restTemplateAddress = new RestTemplate();
        //App1UX1Address resultAddress = restTemplateAddress.getForObject(uriAddress, App1UX1Address.class);
        //System.out.println("valor de resultAddress.getDesc" + resultAddress.getDescripcion().toString());
        
        ResponseEntity<List<App1UX1Address>> response =
        restTemplateAddress.exchange(
            uriAddress,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<App1UX1Address>>() {}
          );
          System.out.println("valor de response.getBody:"+  response.getBody().toString());
        List<App1UX1Address> addressesList = response.getBody();
        addressesPxA=(addressesList.stream().collect(Collectors.toList()));
        System.out.println("valor de addressesPxA:" + addressesPxA.iterator().next().getDescripcion().toString());
        
        //Working code for Person data:
        //String uriPerson = "http://localhost:8080/getperson?name="+id;          
        String uriPerson = "http://host.docker.internal:8080/getperson?name="+id;
        
        
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

            App1UX1Person personXAddress = new App1UX1Person(idPxA,namePxA,edadPxA,addressesPxA);
            System.out.println("addresslist content found:"+ addressesPxA.size()); 
            System.out.println("address in Person objetc found:" + personXAddress.getAddress().iterator().next().toString());
            
            return personXAddress;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        

        return null;
    

    }




}

