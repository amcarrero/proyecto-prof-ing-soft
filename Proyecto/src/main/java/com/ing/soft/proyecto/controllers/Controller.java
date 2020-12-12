package com.ing.soft.proyecto.controllers;

import java.util.List;

import javax.mail.MessagingException;

import com.ing.soft.proyecto.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;

@RestController
@RequestMapping(value = "/petition")
public class Controller {
	
	@Autowired
	private UserPetitionsRepo repository;

	@PostMapping(consumes = "Application/Json")
	public UsersPetitions insertPetition(@RequestBody UsersPetitions petition) throws MessagingException {
		repository.insert(petition);
		EmailSender emailSender = new EmailSender();
		emailSender.enviarConGMail(petition.mail,"UrlComparator: Url recibida","La url "+petition.url+" va a ser monitorizada.\nUn saludo:3");
		return petition;
	}
	
	@GetMapping(produces = "Application/Json")
	public List<UsersPetitions> getPetitions() {
		return repository.findAll();
	}
	
}
