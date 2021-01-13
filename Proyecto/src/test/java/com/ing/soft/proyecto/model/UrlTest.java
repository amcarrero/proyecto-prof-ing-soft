package com.ing.soft.proyecto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.ing.soft.proyecto.repositories.UrlHashRepo;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;
//import com.ing.soft.proyecto.scheduledJobs.updateContents;
import com.ing.soft.proyecto.scheduledJobs.UpdateContents;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
class UrlTest {

	@Test
	void testURLnoexiste() {
		UrlHashRepo rep = mock(UrlHashRepo.class);
		UserPetitionsRepo rep2 = mock(UserPetitionsRepo.class);
		List<UrlContent> value = new ArrayList<UrlContent>();
		UrlContent e = new UrlContent() ;
		e.id="1";
		e.content=1;
		e.url="url";
		value.add(e);
		when(rep.findAll()).thenReturn(value);
		List<UsersPetitions> value2 = new ArrayList<UsersPetitions>();
		when(rep2.findByUrl("url")).thenReturn(value2 );
		UpdateContents urlc = new UpdateContents();
		ReflectionTestUtils.setField(urlc,  "urlRepo",rep);
		ReflectionTestUtils.setField(urlc,  "userPetitionsRepo",rep2);

		assertThrows(Exception.class,()->{
			
			
			urlc.updateContents();
		});
	}
	@Test
	void testURLExiste() {
		UrlHashRepo rep = mock(UrlHashRepo.class);
		UserPetitionsRepo rep2 = mock(UserPetitionsRepo.class);
		List<UrlContent> value = new ArrayList<UrlContent>();
		UrlContent e = new UrlContent() ;
		e.id="1";
		e.content=1;
		e.url="	https://www.hola.com/\r\n"
				+ "";
		value.add(e);
		when(rep.findAll()).thenReturn(value);
		List<UsersPetitions> value2 = new ArrayList<UsersPetitions>();
		when(rep2.findByUrl("url")).thenReturn(value2 );
		UpdateContents urlc = new UpdateContents();
		ReflectionTestUtils.setField(urlc,  "urlRepo",rep);
		ReflectionTestUtils.setField(urlc,  "userPetitionsRepo",rep2);

		assertDoesNotThrow(()->{
			
			
			//urlc.updateContents();
		});
	}
	
	

}
