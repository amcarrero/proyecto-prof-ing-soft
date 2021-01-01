package com.ing.soft.proyecto.controllers;


import com.ing.soft.proyecto.checkersDatabase.CheckExistPetition;
import com.ing.soft.proyecto.model.InserUserResponse;
import com.ing.soft.proyecto.model.UrlContent;
import com.ing.soft.proyecto.model.User;
import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UrlHashRepo;
import com.ing.soft.proyecto.repositories.UserRepo;
import com.ing.soft.proyecto.services.EmailSender;
import com.ing.soft.proyecto.services.GetContentUrl;
import com.ing.soft.proyecto.variables.IntegrationVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "/user")
public class UserController extends IntegrationVariables {

    @Autowired
    private UserRepo userRepository;

    @PostMapping(consumes = "Application/Json")
    public InserUserResponse insertUser(@RequestBody User user)  {
        //se mira si el usuario ya existe, y si es se comprueba
        // la contraseña, si no existe el usuario se crea el usuario
        String userEmail = user.getEmail();
        int userPassword = user.getPassword();
        User newUser;
        if((newUser = userRepository.findByEmail(userEmail)) != null){
            //el usuario existe, por lo que se comprueba la contraseña.
            int passStored = newUser.getPassword();
            int hashPass = (""+passStored).hashCode();
            if(hashPass == passStored){
                //misma contraseña, por lo que bien registrado
                currentUser = userEmail;
            }else{
                //el usuario se registro mal
                return new InserUserResponse(1);
            }
        }else {
            //usuario nuevo
            user.setPassword((user.getPassword()+"").hashCode());
            userRepository.insert(user);
        }
        return new InserUserResponse(0);
    }
}
