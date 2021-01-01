package com.ing.soft.proyecto.checkersDatabase;

import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckExistPetition {

    @Autowired
    private UserPetitionsRepo repository;

    public boolean checkIfAlreadyExist(String url, String mail){
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
