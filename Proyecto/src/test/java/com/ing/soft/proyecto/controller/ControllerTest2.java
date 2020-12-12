package com.ing.soft.proyecto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.ing.soft.proyecto.controllers.Controller;
import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;

class ControllerTest2 {

	@Test
	void testController1() throws MessagingException, IOException {
		Controller c = new Controller();
		UserPetitionsRepo rep = mock(UserPetitionsRepo.class);
		when(rep.insert(Mockito.anyIterable())).thenReturn(null);
		ReflectionTestUtils.setField(c,  "repository",rep);
		UsersPetitions petition =new UsersPetitions();
		petition.mail="waka@waka";
		petition.id="1";
		petition.url="http://circo.com";
		c.insertPetition(petition);
	}
	
	@Test
	void testController2() {
		Controller c = new Controller();
		UserPetitionsRepo rep = mock(UserPetitionsRepo.class);
		List<UsersPetitions> value = new ArrayList<UsersPetitions>();
		when(rep.findAll()).thenReturn(value );
		ReflectionTestUtils.setField(c,  "repository",rep);
		c.getPetitions();

	}

}
