package com.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/bmi")
public class BMIService {
 //<li><a href="/JavaWeb0531/rest/bmi/170/60">/rest/bmi/170/60</li>   
@Path("/{h}/{w}")
@GET
@Produces("text/plain")
public String BMI(@PathParam("h") Integer h,
                          @PathParam("w") Integer w){
 double bmi = w / Math.pow(h/100.0, 2);
 return String.format("BMI=%2f", bmi);
}

//<li><a href="/JavaWeb0531/rest/bmi/?h=170&w=60">/bmi/bmi?h=170&w=60</li>
@Path("/")
@GET
@Produces("text/plain")
public String BMI(@QueryParam("h")  Double h,
                           @QueryParam("w") Double w){
 double bmi = w / Math.pow(h/100.0, 2);
 return String.format("BMI=%2f", bmi);
}
}
