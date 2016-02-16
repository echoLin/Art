<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- <script src="http://www.yuorfei.com:8080/dest/js/fun/chat/sockjs-1.0.3.min.js"></script> -->
    <script src="//cdn.jsdelivr.net/sockjs/1.0.3/sockjs.min.js"></script>
    <script src="http://www.yuorfei.com:8080/dest/js/fun/chat/stomp.min.js"></script>
    <!-- 为了方便起见，js我就直接这么放这儿了 -->
    <script>
    var socket = new SockJS("/hello");
    var stompClient = Stomp.over(socket);

    // callback function to be called when stomp client is connected to server (see Note 2)
    var connectCallback = function() {
         alert("connected!");
         stompClient.subscribe('/topic/greetings', function(greeting){
              alert(JSON.parse(greeting.body).content);
         });
    }; 

    // callback function to be called when stomp client could not connect to server (see Note 3)
    var errorCallback = function(error) {
         // display the error's message header:
         alert(error.headers.message);
    };

    // Connect as guest (Note 4)
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
    </script>
</head>
<body>
    <noscript>
        <h2 style="color: #ff0000">不支持的浏览器版本,丫的是不是用IE了,你这简直是摧残程序员的生命</h2>
    </noscript>
    <hr/>
     
    <p>这只是一个SpringMVC的websocket例子</p>
     
    <div>
        <div>
            <button id="connect" onclick="connect();">连接</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();">
            断开连接</button>
        </div>
        <div id="conversationDiv">
            <label>你要说什么</label><input type="text" id="message" />
            <button id="sendMessage" onclick="sendMessage();">发送</button>
            <p id="response"></p>
        </div>
    </div>
    <hr/>
</body>
</html>