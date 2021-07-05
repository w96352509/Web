package com.Web;

import java.net.URL;
import java.util.Scanner;

public class GetWebData {
     public static void main(String[] args) throws Exception {
        String path = "http://localhost:8080/JavaWeb0531/index.html";
        URL url = new URL(path);
        String html = new Scanner(url.openStream())
                .useDelimiter("\\A")//全選
                .next();
        System.out.println(html);  
       
    }  
}
