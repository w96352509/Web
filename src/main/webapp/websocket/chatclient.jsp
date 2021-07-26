<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat client</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
        <script>
            // char server路徑
            var chaturl = 'http://localhost:8080/JavaWeb0531/websocket/chat';
            //建立websocket物件
            var ws = null;

            function onOpen() {
                ws = new webSocket(chaturl) //發送連線
                ws.onopen = function (evt) { //Server回應
                    console.log('server'+evt.data);
                };
                ws.onmessage=function (evt){
                    console.log('server onmessage'+evt.data);
                 };
                 ws.onclose=function (evt){
                    console.log('server onclose'+evt.data);
                 };
            }
            function send() {
               
            }
            function onClose() {
                 if(ws!=null){
                     ws.close();
                 }else{
                     alert('請先按下open鍵');
                 }
            }
        </script>
    </head>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Chat client</legend>
                <input type="text" id="message" placeholder="請輸入字串" />
                <button type="button" class="pure-button pure-button-primary"
                        onclick="onOpen()" >Open </button>
                <button type="button" class="pure-button pure-button-primary"
                        onclick="send()" >send </button>
                <button type="button" class="pure-button pure-button-primary"
                        onclick="onClose()" >Close </button>
            </fieldset>
        </form>
    </body>
</html>
