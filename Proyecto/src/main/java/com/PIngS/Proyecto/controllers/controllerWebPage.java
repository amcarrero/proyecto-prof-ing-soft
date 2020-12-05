package com.PIngS.Proyecto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class controllerWebPage {

	@GetMapping
	public String HelloWorld() {
		return "Hello world!";
	}
}
