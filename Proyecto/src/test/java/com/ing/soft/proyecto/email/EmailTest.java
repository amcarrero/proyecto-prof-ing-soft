package com.ing.soft.proyecto.email;

import static org.junit.jupiter.api.Assertions.*;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import org.junit.jupiter.api.Test;

import com.ing.soft.proyecto.services.EmailSender;

class EmailTest {

	@Test
	void test() {
		EmailSender es= new EmailSender();
		assertThrows(MessagingException.class,()->{es.enviarConGMail("sujetoA", "Codigo Rojo", "Terminator");});
	}
	@Test
	void test2() {
		EmailSender es= new EmailSender();
		assertThrows(AuthenticationFailedException.class,()->{es.enviarConGMail("sujetoA", "Codigo Rojo", "Terminator");});
	}

}
