<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BMI</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <body style="padding:20px">
        <form class="pure-form" 
             method="post" action="/JavaWeb0531/controller/bmi_session"><%--Post--%>
            <fieldset>
                <legend>BMI (Session版本)</legend>
                <input name="cname" type="text" placeholder="姓名" ><p /> 
               <input name="height" type="text" placeholder="身高" ><p /> 
               <input name="weight" type="text" placeholder="體重" ><p /> 
                <button type="submit" class="pure-button pure-button-primary">傳送</button>
                <button type="button" onclick="location.href='/JavaWeb0531/controller/bmi_session'"<%--Get--%>
                 class="pure-button pure-button-primary">檢視</button>
            </fieldset>
        </form>
    </body>
</html>
