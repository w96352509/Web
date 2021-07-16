package com.web.rest;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest") //此路徑後 都套用rest
public class MyRestApplication extends  Application{ //rest的跟 

    @Override
    public Set<Class<?>> getClasses() {
        //註冊 Rest service
        Set<Class<?>> classes = new LinkedHashSet();
        classes.add(HelloService.class);
        classes.add(BMIService.class);
        classes.add(BookService.class);
        return super.getClasses(); //哪些class是rest將註冊進去
   }
   
}
