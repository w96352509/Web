package com.web.rest;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class MyRestApplication extends  Application{

    @Override
    public Set<Class<?>> getClasses() {
        //註冊 Rest service
        Set<Class<?>> classes = new LinkedHashSet();
        
        return super.getClasses(); //那些class是rest將註冊進去
   }
   
}
