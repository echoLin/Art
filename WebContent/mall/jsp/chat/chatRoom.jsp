<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author" content="Weltion" />
<meta name="applicable-device" content="mobile" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title>聊天</title>
<link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
<link href="/Art/mall/css/chat.css" rel="stylesheet" type="text/css" />
<script src="http://cc.lenovows.com/assets/js/lib/jquery.js?bust=1" type="text/javascript"></script>
</head>
<body>

<!--页面加载 开始-->
<div id="preloader">
    <div id="status">
        <p class="center-text"><span>拼命加载中···</span></p>
    </div>
</div>
<!--页面加载 结束-->

<div id="px832kcdw" class="xmeet-chat-window" style="display: block;width: 100%;">


    <div id="server_wrapper" style="display: none">
        <p>Server
            <input type="text" name="host" id="host" value="ws://meet.xpro.im:8080/xgate/websocket/weplus？neckname=weltion">
            <input type="submit" name="host_connect" id="host_connect" value="重新连接" disabled="disabled">
        </p>
    </div>

    <div class="window-title">
        <img width="48" height="48" src="http://meet.xpro.im/v2/api/img/chat.png">
        <span class="title">${friend.username }</span>
        <span class="exit"></span>
        <span class="userList "></span>
        <span class="setting"></span>

    </div>


    <div class="window-body chat-messages">

        <div class="userList-panel" style="top: -320px;">
            <ul class="users"><li>weltion</li><li>小M机器人</li></ul>
            <div class="close-panel">×</div>
        </div>
        <div class="setting-panel">
            昵称：<input class="nickName" type="text" maxlength="20">
            <div class="close-panel">×</div>
        </div>

        <div id="console_wrapper" class="chat-messages-list"  style="transform: matrix(1, 0, 0, 1, 0, 0);">
           <pre id="console">
           </pre>
        </div>
    </div>


    <div class="chat-input-bar">
        <div class="chat-info-container">
        </div>
        <div class="chat-effect-container" style="left: 0px; top: 0px;">
            <div class="chat-effect-bar"></div>
        </div>
        <div class="chat-input-wrapper">
            <button class="chat-input-tool" style="margin-top: 3px">
                <i class="icon-emotion"></i>
            </button>
            <input class="chat-input" type="text" name="console_input" id="console_input">
            <button class="chat-send" name="console_send" id="console_send" >
                <i class="icon-send" style="transform: translate3d(0px, 0px, 0px);"></i>
            </button>
        </div>
    </div>

    <div class="emotion-panel" style="display: none;">
        <img src="http://meet.xpro.im/v2/api/img/emotion/1.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/2.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/3.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/4.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/5.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/6.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/7.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/8.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/9.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/10.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/11.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/12.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/13.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/14.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/15.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/16.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/17.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/18.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/19.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/20.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/21.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/22.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/23.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/24.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/25.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/26.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/27.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/28.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/29.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/30.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/31.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/32.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/33.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/34.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/35.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/36.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/37.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/38.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/39.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/40.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/41.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/42.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/43.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/44.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/45.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/46.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/47.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/48.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/49.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/50.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/51.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/52.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/53.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/54.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/55.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/56.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/57.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/58.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/59.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/60.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/61.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/62.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/63.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/64.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/65.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/66.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/67.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/68.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/69.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/70.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/71.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/72.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/73.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/74.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/75.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/76.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/77.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/78.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/79.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/80.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/81.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/82.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/83.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/84.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/85.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/86.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/87.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/88.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/89.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/90.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/91.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/92.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/93.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/94.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/95.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/96.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/97.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/98.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/99.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/100.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/101.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/102.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/103.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/104.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/105.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/106.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/107.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/108.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/109.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/110.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/111.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/112.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/113.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/114.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/115.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/116.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/117.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/118.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/119.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/120.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/121.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/122.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/123.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/124.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/125.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/126.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/127.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/128.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/129.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/130.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/131.gif" width="24px" height="24px"><img src="http://meet.xpro.im/v2/api/img/emotion/132.gif" width="24px" height="24px"></div>

</div>

</body>

</html>