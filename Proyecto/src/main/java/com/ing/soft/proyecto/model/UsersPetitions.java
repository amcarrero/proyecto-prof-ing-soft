package com.ing.soft.proyecto.model;

import org.springframework.data.annotation.Id;

public class UsersPetitions {

	  @Id
	  public String id;

	  public String mail;
	  public String url;

	  public UsersPetitions() {}

	  public UsersPetitions(String mail, String url) {
	    this.mail = mail;
	    this.url = url;
	  }

	  @Override
	  public String toString() {
	    return String.format(
	        "UsersPetitions[id=%s, mail='%s', url='%s']",
	        id, mail, url);
	  }

	
}
