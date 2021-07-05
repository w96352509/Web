<%@page import="java.util.Date"%>
<%@taglib uri="http://my.scwcd" prefix="my" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:required/></h1><%--*--%>
        <h1><my:greet /></h1>     <%--print Hello--%>
        <h1><my:greet user="vincent"/></h1> 
        <h1><my:greet user="vincent ${1+2}"/></h1>
        <h1>
            <my:if condition="<%=new Date().getTime() %2 ==0%>">
         現在時間:<%=new Date()%>
            </my:if>
         </h1>
        <h1>
            <my:loop count="3"> 
            Peko
            </my:loop>
        </h1>
        <hr><%--搜尋有S的字串--%>
          <my:mark search="s">
          she sell sea shore on the sea shore
          </my:mark>  
        <hr>
        <h1><%--抓session的變數--%>
            <my:implicit attributeName="authCode" scopeName="session" />       
        </h1>
        <h1>
            <my:switch conditionValue="1">
                <my:case caseValue="1">男生</my:case> 
                <my:case caseValue="2">女生</my:case> 
                <my:default>錯誤</my:default>
            </my:switch>   
        </h1>   
    </body>
</html>
