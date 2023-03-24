package com.example.app2ux1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class App2Ux1Controller {
    @GetMapping("/app2-ux1-getperson")
	public App2UX1Person getPerson(@RequestParam(value = "name", defaultValue = "World") String name) {
		return App2UX1Person.getById(name);
	}
}
