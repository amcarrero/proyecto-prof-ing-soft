package com.PIngS.Proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
	
	 @GetMapping("/hello")
	 public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	 return String.format("Hello %s!", name);
	 }
	 
     public @Bean MongoClientFactoryBean mongo() {
         MongoClientFactoryBean mongo = new MongoClientFactoryBean();
         mongo.setHost("mongo");
         return mongo;
    }

}
