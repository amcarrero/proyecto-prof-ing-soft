package com.ing.soft.proyecto.controllers;

import java.io.IOException;
import java.util.List;

import com.ing.soft.proyecto.model.UrlContent;
import com.ing.soft.proyecto.repositories.UrlHashRepo;
import com.ing.soft.proyecto.services.EmailSender;
import com.ing.soft.proyecto.services.GetContentUrl;
import javax.mail.MessagingException;

import com.ing.soft.proyecto.variables.CurrentUser;
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
public class Controller extends CurrentUser {
	
	@Autowired
	private UserPetitionsRepo repository;

	@Autowired
	private UrlHashRepo urlRepository;

	@PostMapping(consumes = "Application/Json")
	public UsersPetitions insertPetition(@RequestBody UsersPetitions petition) throws IOException, MessagingException {
		petition.setMail(currentUser);
		//se comprueba si el usuario ha solicitado ya esta peticion
		System.out.println("el usuario es"+currentUser);
		if(!checkIfAlreadyExist(petition.url, currentUser)){
			//insert user petition in database
			repository.insert(petition);
			// send email to confirm
			EmailSender emailSender = new EmailSender();
			emailSender.enviarConGMail(petition.mail,"UrlComparator: Url recibida","La url "+petition.url+" va a ser monitorizada.\nUn saludo:3");
			//insert the current content of url in database
			GetContentUrl urlContent = new GetContentUrl();
			String content = urlContent.getContentUrl(petition.getUrl());
			UrlContent url = new UrlContent(petition.url, content.hashCode());
			urlRepository.insert(url);
		}else{
			System.out.println("Esta petición ya se ha realizado");
		}

		return petition;
	}


	
	@GetMapping(produces = "Application/Json")
	public List<UsersPetitions> getPetitions() {
		return repository.findAll();
	}


	private boolean checkIfAlreadyExist(String url, String mail){
		System.out.println("el repositorio es: "+repository);
		if (repository.findAll() != null) {
			List<UsersPetitions> users = repository.findAll();
			for ( int i =0;i<users.size();i++) {
				if (users.get(i).url.equals(url) && users.get(i).mail.equals(mail)) {
					return true;
				}
			}
			return false;
		}else{
			return true;
		}
	}
	
}
