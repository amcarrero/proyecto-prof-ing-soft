package com.ing.soft.proyecto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class ProyectoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String welcome() {
	     return "formulario";
	 }
	
	   
     public @Bean MongoClientFactoryBean mongo() {
         MongoClientFactoryBean mongo = new MongoClientFactoryBean();
         String dbHost = System.getProperty("dbHost");
         System.out.println(dbHost);
         if(dbHost != null) {
        	 mongo.setHost(System.getProperty("dbHost"));
        	 mongo.setPort(Integer.valueOf(System.getProperty("dbPort"))); 
         }
         else
        	 mongo.setHost("mongo");

         return mongo;
    }

}
