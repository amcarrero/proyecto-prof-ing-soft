package com.ing.soft.proyecto;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@Testcontainers
class AppITTest {
	
	private static final String DB_IMAGE = "mongo:4.2.1";
	private static final int DB_PORT = 27017;

	@Container
	private static GenericContainer<?> mongo = new GenericContainer<>(DB_IMAGE)
			.withExposedPorts(DB_PORT);
	
	@BeforeAll
	static void  setup() {
        System.setProperty("dbHost", mongo.getHost());
        System.setProperty("dbPort", mongo.getMappedPort(DB_PORT)+"");
        ProyectoApplication.main(new String[0]);
    }

	
	void shouldInsertPetition() {
	}


	@Test
	void contextLoads() {
	}

}
