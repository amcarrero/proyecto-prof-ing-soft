package com.ing.soft.proyecto.scheduledJobs;

import com.ing.soft.proyecto.model.UrlContent;
import com.ing.soft.proyecto.model.UsersPetitions;
import com.ing.soft.proyecto.repositories.UrlHashRepo;
import com.ing.soft.proyecto.repositories.UserPetitionsRepo;
import com.ing.soft.proyecto.services.EmailSender;
import com.ing.soft.proyecto.services.GetContentUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class updateContents {

    @Autowired
    public UrlHashRepo urlRepo;
    @Autowired
    public UserPetitionsRepo userPetitionsRepo;

    //se ejecuta cada media hora
    @Scheduled(cron = "0 0/30 * ? * * *")
    public void updateContents() throws IOException {
        List<UrlContent> listUrl = urlRepo.findAll();

        for (int i=0; i< listUrl.size();i++){
            String url = listUrl.get(i).url;
            int hash = listUrl.get(i).content;
            GetContentUrl getContentUrl = new GetContentUrl();
            String content = getContentUrl.getContentUrl(url);
            if(hash != content.hashCode()){
                //si no es igual, se manda un correo a todos los usuarios que hayan pedido usar este seguimiento
                List<UsersPetitions> listUser = userPetitionsRepo.findByUrl(url);
                EmailSender esender = new EmailSender();
                for(int j =0; j< listUser.size();j++){
                    esender.enviarConGMail(listUser.get(j).mail,"Url modificada","La url "+listUser.get(j).url+" ha sido modificada");
                }


            }
        }
    }

}
