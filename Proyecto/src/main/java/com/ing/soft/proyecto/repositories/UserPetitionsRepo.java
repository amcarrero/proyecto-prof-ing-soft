package com.ing.soft.proyecto.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.ing.soft.proyecto.model.UsersPetitions;

public interface UserPetitionsRepo extends MongoRepository<UsersPetitions, String>{

	public List<UsersPetitions> findByMail(String mail);
	public List<UsersPetitions> findByUrl(String url);
}
