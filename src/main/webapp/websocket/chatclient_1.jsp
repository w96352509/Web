<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat client</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
    </head>
    <script>
        // char server 路徑
        var chaturl = 'ws://localhost:8080/JavaWeb0531/websocket/chat1';
        //建立 websocket物件
        var ws = null;
                function onOpen() {
                ws = new webSocket(chaturl); //發送連線
                ws.onopen() = function(evt){
                console.log('server onopen:' + evt.data)
                };
                ws.onmessage() = function(evt){
                console.log('server onMessage:' + evt.data)
                };
                ws.onclose() = function(evt){
                console.log('server onClose' + evt.data);
                ws = null
                };
                result.insertAdjacentHTML("beforeend", '連到 server <br>'); //beforeend:在 element 裡面，最後一個子元素之後。
                }

        function send() {
        ws.send(message.value);
        }
        function onClose() {
        if (ws != null) {
        ws.close();
        } else {
        alert('請先按下open');
        }
        }

    </script>
    <body style="padding: 20px">
        <form class="pure-form">
            <fieldset>
                <legend>Chat client</legend>
                <input type="text" id="message" placeholder="請輸入字串" />
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="onOpen()">Open</button>
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="send()">Send</button>
                <button type="button" 
                        class="pure-button pure-button-primary"
                        onclick="onClose()">Close</button>
            </fieldset>
        </form>
        <div id="result"></div>

    </body>
</html>