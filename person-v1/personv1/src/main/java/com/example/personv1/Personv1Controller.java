package com.example.personv1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Personv1Controller {
    
    @GetMapping("/getperson")
	public Personv1 getPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("bs-person-v1 invocado");
		return Personv1.getById(name);
	}


}
