package com.ing.soft.proyecto.model;

import static org.assertj.core.api.BDDAssertions.then;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 *
 * @author adrian
 */
class UserPetitionsTest {

	private String mail;
	private String url;
	private UsersPetitions petition;

	@BeforeEach
	void setUp() {

		mail = "test@example.com";
		url = "http://www.test.com";

		petition = new UsersPetitions(mail, url);
	}

	@Test
	void shouldReturnFields() {

		then(petition.getMail()).isEqualTo(mail);
		then(petition.getUrl()).isEqualTo(url);
	}

	@Test
	void shouldSetAndReturnFields() {

		String mail = "other";
		String url = "other";

		petition.setMail(mail);
		petition.setUrl(url);

		then(petition.getMail()).isEqualTo(mail);
		then(petition.getUrl()).isEqualTo(url);
	}

	@Test
	void shouldSerialize() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(petition);

		String jsonMock = "\"mail\":\"" + mail + "\",\"url\":\""
				+ url + "\"";

		then(json).contains(jsonMock);
	}

}
