package com.example.accountv1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Accountv1Controller {
    @GetMapping("/bs-getaccount")
	public List<Accountv1> getAddress(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("bs-account-v1 invocado");
		return Accountv1.getByPersonId(name);
		
	}
}
