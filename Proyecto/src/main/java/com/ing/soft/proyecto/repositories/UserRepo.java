package com.ing.soft.proyecto.repositories;


import com.ing.soft.proyecto.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


public interface UserRepo extends MongoRepository<User, String>{

    public User findByEmail(String email);

}
