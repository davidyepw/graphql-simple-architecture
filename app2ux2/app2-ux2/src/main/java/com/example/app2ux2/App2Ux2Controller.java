package com.example.app2ux2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App2Ux2Controller {
    @GetMapping("/app2-ux2-getaccounts")
	public List<App2Ux2Account> getPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		return App2Ux2Accounts.getById(name);
	}
}
