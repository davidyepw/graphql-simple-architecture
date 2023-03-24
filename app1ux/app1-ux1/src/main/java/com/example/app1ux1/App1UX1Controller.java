package com.example.app1ux1;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@RestController
public class App1UX1Controller {
    @GetMapping("/getpersonaddress")
	public App1UX1Person getPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		return App1UX1PersonXAddress.getById(name);
	}
}
