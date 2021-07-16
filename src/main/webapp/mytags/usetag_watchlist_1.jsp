<%@page import="java.util.Random"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@taglib uri="/tlds/mytld" prefix="cc" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watch List</title>
        <style>
            .head{
                background-color:#003344;color: white;font-weight: bold;font-size: 30px;
                text-align: center;padding: 10px;
            }

        </style>
    </head>
  <header class="head">報告</header>
  <div id="content" style="background-color:#EEEEEE;float:left;">
  <body style="padding: 15px">
   <my:watchlist_1 symbols="${ param.symbols }" />
        </body>
    </div>
</html>