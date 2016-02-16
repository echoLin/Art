<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="author" content="m.178hui.com" />
    <meta name="applicable-device" content="mobile" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
    <c:if test="${not empty title }">
    <title>${title }</title>
    </c:if>
    <link href="/Art/mall/css/public.css" rel="stylesheet" type="text/css" />
    <link href="/Art/mall/css/order.css" rel="stylesheet" type="text/css">
    <script src="/Art/mall/js/jquery-1.8.3.min.js"></script>

    <script>
        $(window).load(function() {
            $("#status").fadeOut();
            $("#preloader").delay(350).fadeOut("slow");
        })
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".login_out").click(function(){
                layer.confirm('您确定要退出吗？',  {skin: 'layui-layer-molv',offset: '30%'}, function(index){
                    layer.close(index);
                    layer.msg('拜拜！欢迎下次光临！', {shift: 6, time: 1500},function(){
                        window.location='';
                    });
                });
            });
        });
    </script>

</head>

<body>
<div class="mobile">

    <!--页面加载 开始-->
    <div id="preloader">
        <div id="status">
            <p class="center-text"><span>拼命加载中···</span></p>
        </div>
    </div>
    <!--页面加载 结束-->

    <!--header 开始-->
    <header>
        <div class="header"> <a class="new-a-back" href="javascript:history.back();"> <span><img src="/Art/mall/images/iconfont-fanhui.png"></span> </a>
            <c:if test="${not empty title }"><h2>${title }</h2></c:if>
            <div class="header_right shaixuan"><a href="/Art/mall/index"><img src="/Art/mall/images/iconfont-shouye.png"></a></div>
        </div>
    </header>
    <!--header 结束-->

	<c:if test="${not empty orderList }">
    <div  class="order_list w">

        <ul style="height: auto">

			
			<c:forEach var="order" items="${orderList }">
			
			<li>
                <a href="/Art/mall/jsp/artist/shop/shoporder/orderdetail?id=${order.id}&shop_id=${shop_id}">
                    <div style="border-bottom-color: #666666 ">
                        <div class="u_nav_name">${order.artwork.name }</div>
                        <div class="nt_icon"></div>
                        <div class="u_nav_status">
						</div>
                    </div>
                    <div class="order_content">
                        <div class="bl_img"><img src="${order.artwork.head_url}" /></div>
                        <div class="bl_right">
                            <table border="0" style="width: 100%">
                                <tr style="font-size: 12px;color: #666666;line-height: 23px">
                                    <td >
                                        作者：${order.artwork.shop.artist.real_name}<br/>
                                        价格：￥${order.artwork.price }<br/>
                                        时间：${order.time}
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </a>
            </li>
            
			</c:forEach>		

        </ul>

    </div>
    
    </c:if>
    
    <c:if test="${empty orderList }">
    	<div class="copyright" style="margin-top:20px">目前没有可查看的订单哦~~~~</div>
    </c:if>
</div>

</div>
</body>
</html>


