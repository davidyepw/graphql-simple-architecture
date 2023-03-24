package com.graphqljava.tutorial.bookdetails;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Address {
    private String idAddress;
    private String descripcion;
    private String distrito;

    public static List<Address> getAddressesByPersonId (String idPersona){
        
        //String uriAddress = "http://localhost:8082/getaddress?name="+idPersona;
        String uriAddress = "http://host.docker.internal:8082/getaddress?name="+idPersona;
        RestTemplate restTemplateAccount = new RestTemplate();
               
        ResponseEntity<List<Address>> response =
        restTemplateAccount.exchange(
            uriAddress,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Address>>() {}
          ); 
          
        List<Address> addressesList = response.getBody();
        
        System.out.println("size de addressesList:"+  addressesList.size());
        return addressesList;
        
        
    }

    public String getidAddress() {
        return idAddress;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getDistrito() {
        return distrito;
    }
}

