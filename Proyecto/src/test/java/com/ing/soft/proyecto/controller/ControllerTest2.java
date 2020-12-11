package com.ing.soft.proyecto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.ing.soft.proyecto.controllers.Controller;
import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;

class ControllerTest2 {

	@Test
	void test() {
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

}
