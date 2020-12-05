package com.ing.soft.proyecto.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.soft.proyecto.model.UrlContent;
import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UrlHashRepo;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;
import com.ing.soft.proyecto.services.EmailSender;
import com.ing.soft.proyecto.services.GetContentUrl;

@RestController
@RequestMapping(value = "/petition")
public class Controller {
	
	@Autowired
	private UserPetitionsRepo repository;

	@Autowired
	private UrlHashRepo urlRepository;

	@PostMapping(consumes = "Application/Json")
	public UsersPetitions insertPetition(@RequestBody UsersPetitions petition) throws IOException,MessagingException {
		repository.insert(petition);
		// send email to confirm
		EmailSender emailSender = new EmailSender();
		emailSender.enviarConGMail(petition.mail,"UrlComparator: Url recibida","La url "+petition.url+" va a ser monitorizada.\nUn saludo:3");
		//insert the current content of url in database
		GetContentUrl urlContent = new GetContentUrl();
		String content = urlContent.getContentUrl(petition.getUrl());
		UrlContent url = new UrlContent(petition.url, content.hashCode());
		urlRepository.insert(url);
		return petition;
	}
	
	@GetMapping(produces = "Application/Json")
	public List<UsersPetitions> getPetitions() {
		return repository.findAll();
	}
		
}
