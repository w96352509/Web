package com.Web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//請求資訊(URL):http://localhost:8080/JavaWeb0531/hi?name=John(透過網址取得參數(?name=John))
// /hi                ->url-pattern  ,要到WEB-INF/web.xml 中設定配置
//JavaWeb0531->context.xml ,要到META-INF/context.xml 中設定配置
public class HellowGenericServlet  extends GenericServlet{

@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
 //req表示收到client的請求資訊  
String name = req.getParameter("name");
//res表示要回應給client端的內容
  System.out.printf("Hi %s %s\n",name,new Date());//印在Server的consle中(通常用於debug或觀察變數)
   PrintWriter out= res.getWriter();//透過out可以將訊息回傳給client
   out.print("Hi");//把訊息寫在HTTP Response 文件的Part 4(第4層)
   out.print(name);
   out.print(" "+ new Date());
    
    }
    
}
