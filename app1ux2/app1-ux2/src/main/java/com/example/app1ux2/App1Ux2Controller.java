package com.example.app1ux2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class App1Ux2Controller {
    
    @GetMapping("/getpersonaccount")
	public App1UX2Person getPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		return App1UX2PersonXAccount.getById(name);
	}

}
