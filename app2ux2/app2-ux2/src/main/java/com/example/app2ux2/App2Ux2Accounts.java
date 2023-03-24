package com.example.app2ux2;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class App2Ux2Accounts {

    public static List<App2Ux2Account> getById(String id) {


        final List<App2Ux2Account> accountsPxA;

        //String uriAccount = "http://localhost:8083/bs-getaccount?name="+id;
        String uriAccount = "http://host.docker.internal:8083/bs-getaccount?name="+id;
        RestTemplate restTemplateAccount = new RestTemplate();
                
        ResponseEntity<List<App2Ux2Account>> response =
        restTemplateAccount.exchange(
            uriAccount,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<App2Ux2Account>>() {}
          );
        System.out.println("valor de response.getBody:"+  response.getBody().toString());
        List<App2Ux2Account> accountsList = response.getBody();
        accountsPxA=(accountsList.stream().collect(Collectors.toList()));
        System.out.println("valor de accountsPxA:" + accountsPxA.iterator().next().getAccountNum().toString());
        return accountsList;
    }

}





