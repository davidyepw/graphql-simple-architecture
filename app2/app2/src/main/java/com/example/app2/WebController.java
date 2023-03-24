package com.example.app2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller

public class WebController {
    @GetMapping("/funcionalidad1")
	public String funcionalidad1(@RequestParam(name="id", required=false, defaultValue="11111111") String id, Model model) {
		
        System.out.println("id valor:" +id);
        String uriPerson = "http://localhost:8087/app2-ux1-getperson?name="+id;
                
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

          //  App2Person app2person = new App2Person(id,personJson.getName(),personJson.getEdad());
          //  System.out.println("app2ux1person content found:"+ app2person); 
          //  System.out.println("name in app2ux1person objetc found:" + app2person.getName());
            
            model.addAttribute("id", id);
            model.addAttribute("nombre", personJson.getName());
            model.addAttribute("edad", personJson.getEdad());
            return "funcionalidad1";
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        //model.addAttribute("id", id);
		return "funcionalidad1";
	}

    @GetMapping("/funcionalidad2")
	public String funcionalidad2(@RequestParam(name="id", required=false, defaultValue="11111111") String id, Model model) {
		
        
        List<AccountJSON> accountsPxA;

  
        System.out.println("id valor:" +id);
        String uriApp2Ux2 = "http://localhost:8089//app2-ux2-getaccounts?name="+id;
                
        RestTemplate restTemplateAccount = new RestTemplate();
        System.out.println("Created RestTemplate object");
        System.out.println("setted id: "+ id);

        ResponseEntity<List<AccountJSON>> response =
        restTemplateAccount.exchange(
            uriApp2Ux2,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<AccountJSON>>() {}
              );
              System.out.println("valor de response.getBody:"+  response.getBody().toString());
            List<AccountJSON> accountsList = response.getBody();
            accountsPxA=(accountsList.stream().collect(Collectors.toList()));
            
            List<String> headers = Arrays.asList("numcuenta", "tipocuenta", "balance");
            List<Map<String, Object>> rows = new ArrayList<>();
            System.out.println("valor de accountsPxA: "+accountsPxA.iterator().next().getAccountNum().toString());
            System.out.println("valor de accountsPxA: "+accountsPxA.iterator().next().getAccountType().toString());
            for(AccountJSON b : accountsPxA)
            {
                System.out.println("cuenta: "+b.getAccountNum()+"tipo cuenta: "+b.getAccountType()+"balance: "+b.getBalance()); 
                rows.add(Map.of("numcuenta", b.getAccountNum(), "tipocuenta", b.getAccountType(), "balance", b.getBalance()));
            }

            model.addAttribute("id", id);
            model.addAttribute("headers", headers);
            model.addAttribute("rows", rows);
            return "funcionalidad2";
 	}
}
