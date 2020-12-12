package com.ing.soft.proyecto.services;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class GetContentUrl {

    public String getContentUrl (String newUrl) throws IOException {

        //Instantiating the URL class
        URL url = new URL(newUrl);
        //Retrieving the contents of the specified page
        Scanner sc = new Scanner(url.openStream());
        //Instantiating the StringBuffer class to hold the result
        StringBuffer sb = new StringBuffer();
        while(sc.hasNext()) {
            sb.append(sc.next());
        }
        //Retrieving the String from the String Buffer object
        String result = sb.toString();
        //Removing the HTML tags
        result = result.replaceAll("<[^>]*>", "");
        //System.out.println("Contents of the web page: "+result);
        return result;
    }
}
