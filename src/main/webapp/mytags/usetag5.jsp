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
            <my:exchange symbol="USDTWD=x"></my:exchange>
            <my:exchange symbol="TWDUSD=x"></my:exchange>
        </h1>
    </body>
</html>
