package com.example.addressv1;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Addressv1Controller {
    
	@GetMapping("/getaddress")
	public List<Addressv1> getAddress(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("bs-address-v1 invocado");
		return Addressv1.getByPersonId(name);
		
	}

}
