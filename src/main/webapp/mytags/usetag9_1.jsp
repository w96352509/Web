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
         </style>
    </head>
    <body>
        <%response.setIntHeader("Refresh", 10);%>
        <div class='head'>
         <h1>
            原報告：<br>
        </h1>   
        </div>
        <h1>
  今日研究報告:<my:report2 symbol="2330.TW" ></my:report2><input type='button' value='下單' id='a' />將在大陸設晶圓廠<br/>
            2.<my:report2 symbol="2308.TW" ></my:report2><input type='button' value='下單' id='a' />....<br/>
            3.<my:report2 symbol="2317.TW" ></my:report2><input type='button' value='下單' id='a' />....<br/>
            4.<my:report2 symbol="AAPL" ></my:report2><input type='button' value='下單' id='a' />.....
            
        </h1>
    </body>
</html>