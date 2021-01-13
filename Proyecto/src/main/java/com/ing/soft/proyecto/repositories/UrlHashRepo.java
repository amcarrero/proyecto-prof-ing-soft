package com.ing.soft.proyecto.repositories;


import java.util.List;
import com.ing.soft.proyecto.model.UrlContent;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UrlHashRepo extends MongoRepository<UrlContent, String> {

    public List<UrlContent> findByUrl(String url);
}
