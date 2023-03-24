package com.example.app2graphql;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @QueryMapping
    public Person getPerson(@Argument String id) {
        System.out.println("getPerson called");
        System.out.println("value:" + Person.getById(id));
        return Person.getById(id);
    }
  
    @SchemaMapping
    public List<Account> account(Person person) {
        System.out.println("SchemaMapping Account");
        return Account.getAcountByPersonId(person.getId());
    }

}