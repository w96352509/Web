<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" uri="/tlds/mytld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
         #a{width: 80px; height: 40px; font-size: 20px;}
          .head{
             background-color:#003344;color: white;font-weight: bold;font-size: 30px;
             text-align: center;padding: 10px;
             }  
        </style>
    </head>
    <body>
        <%response.setIntHeader("Refresh", 10);%>
        <div class='head'>
         <h1>
            原報告：<br>
            今日研究報告:台積電將在大陸設晶圓廠 ...
        </h1>   
        </div>
        <h1>
         加值報告：<br> <!--  △ ▽ -->
         今日研究報告:<br>
         台積電:
            <my:report></my:report><input type='button' value='下單' id='a' />將在大陸設晶圓廠 ...
        </h1>
    </body>
</html>