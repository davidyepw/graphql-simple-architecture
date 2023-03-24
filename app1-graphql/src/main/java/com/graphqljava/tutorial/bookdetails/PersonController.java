package com.graphqljava.tutorial.bookdetails;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @QueryMapping
    public Person getPerson(@Argument String id) {
        System.out.println("app1-graphql-ms invocado para personId: " + id);
        //System.out.println("value:" + Person.getById(id));
        return Person.getById(id);
    }
  
    @SchemaMapping
    public List<Account> account(Person person) {
        //System.out.println("SchemaMapping Account");
        return Account.getAcountByPersonId(person.getId());
    }

    @SchemaMapping
    public List<Address> address(Person person) {
        //System.out.println("SchemaMapping Address");
        return Address.getAddressesByPersonId(person.getId());
    }

}