<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/mytld" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <my:bmi h="170.0" w="80.0" ></my:bmi>
            <my:bmi h="170" w="80" result="true" ></my:bmi>
        </h1>
    </body>
</html>
