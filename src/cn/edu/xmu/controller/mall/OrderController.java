/**
 * 
 */
package cn.edu.xmu.controller.mall;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.service.mall.OrderService;
import cn.edu.xmu.controller.AOP.isUser;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 weltion
 * All rights reserved
 *
 * @file OrderController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 用户订单控制器
 */
@Controller
public class OrderController {
	@Resource(name="orderService_mall")
	private OrderService orderService;
	
	/**
	 * 
	 * @Method toOrder
	 * @exception 进入订单首页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping(value={"/mall/jsp/order/order","/mall/jsp/order"})
	@isUser
	public String toOrder(HttpServletRequest request, HttpServletResponse response){
		return "/mall/jsp/order/order";
	}

	/**
	* @Method toOrderDetail
	* @exception 进入订单详情
	* @param id 订单ID
	* @param user_id 用户ID
	* @param request 请求
	* @param response 响应
	* @return 
	* @author weltion
	* @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/order/orderdetail")
	@isUser
	public String toOrderDetail(Long id,HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		//返回订单详情
		Order order = orderService.getOrderByIdAndUser(id,user.getUserid());
		request.setAttribute("order", order);
		List<Payment> list = orderService.getPaymentListByOrderAndFrom(order, user);
		Payment payment = null;
		if(list != null){
			for(int i = 0; i <list.size(); i++)
				if(list.get(i).getIs_pay()!=1)
					payment = list.get(i);
		}
		
		String Type_title=null;
		
		if(order.getType()==4){
			Type_title = "拍卖品";
		}
		else if(order.getType()==3){
			Type_title = "订制品";
		}
		else if(order.getType()==1){	
			Type_title = "非卖品";
		}
		else{
			Type_title = "可购商品";
		}
		request.setAttribute("Type_title", Type_title);
		
		
		//确认支付按钮
		String button_pay_order= "<div class=\"go_buy\"  style=\"margin-top 5px\" >";
		if(payment != null)
			button_pay_order += "<a href='/Art/mall/jsp/buy/pay?payment_id="+payment.getId()+"'+>确认支付</a></div>";
		else
			button_pay_order += "<a>确认支付</a></div>";
		
		//失效的物流按钮
				String button_disabled_express= new String(
								"<div class=\"go_buy\"  style=\"margin-top 5px \"   onclick=\"disable_express()\"  >"
								+"<a href=\"\">查看物流</a></div>"
		);
				
		//评论按钮
		String button_comment= new String(
								"<div class=\"go_buy\"  style=\"margin-top 5px\" >"
								+"<a href=\"\">发布评论</a></div>"
		);
		
		//评论失效按钮
		String button_disabled_comment= new String(
								"<div class=\"go_buy\"  style=\"margin-top 5px\" >"
								+"<a href=\"\">已评论过</a></div>"
		);
		
		//查看物流按钮
		String button_check_express= new String(
				"<div class=\"go_buy\"  style=\"margin-top 5px\" >"
				+"<a href=\"http//m.kuaidi100.com/index_all.html?type="
				+order.getExpress_company()
				+"&postid="
				+order.getTracking_number()
				+"&callbackurl=http//115.28.94.2548080/Art/mall/jsp/order/order"
				+"\">查看物流</a></div>"
		);
				
		if(order.getStatus()==1){//待付款订单，也就是购买订单
					request.setAttribute("button_pay_order", button_pay_order);
		}
		else if(order.getStatus()==2){//待发货订单，不能查物流
					request.setAttribute("button_disabled_express", button_disabled_express);
		}
		else if(order.getStatus()==3){//已货订单，可查物流
			request.setAttribute("button_check_express", button_check_express);
		}
		else if(order.getStatus()==4){//待评价订单，可评价
			request.setAttribute("button_comment", button_comment);
		}
		else if(order.getStatus()==5){//已评价订单，不能评价
			request.setAttribute("button_disabled_comment", button_disabled_comment);
		}
		else if(order.getType() == 3 ){
					String stage="1";
					request.setAttribute("stage", stage);
					
		}
		
		return "/mall/jsp/order/orderdetail";
	}
	
	
	/**
	* @Method toOrderList
	* @exception 返回订单列表
	* @param user_id 用户ID
	* @param status 订单状态
	* @param request 请求
	* @param response 响应
	* @return 
	* @author Weltion
	* @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/order/orderlist")
	@isUser
	public String toOrderList(Integer type,Integer status,Integer page,HttpServletRequest request,
			HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//返回订单列表
		Long user_id=user.getUserid();
		List<Order> orderList = null;
		
		String title=null;
		String Status_title=null;
		String Type_title=null;
		
		if(type!=3){//非订制品
			if( status ==1 ){
				title = "待付款订单";
				Status_title = "待付款";
			}
			else if(status ==2){
				title = "待发货订单";
				Status_title = "未发货";
			}
			else if(status ==3){
				title = "已发货订单";
				Status_title = "运途中";
			}
			else if(status ==5){
				title = "历史订单";
				Status_title = "已评价";
			}
			orderList = orderService.getOrderListByUserAndStatus(user_id, status, page);
		}else if(type==3 && status==1){//未完成首付的订制品
			title = "待付款订单";
			orderList = orderService.getOrderListByUserAndStatus(user_id, status, page);
		}else if(type==3 && status!=1){//完成首付的订制品
			title = "定制订单";
			if(status ==2){
				Status_title = "未发货";
			}
			else if(status ==3){
				Status_title = "运途中";
			}
			else if(status ==5){
				Status_title = "已评价";
			}
			orderList = orderService.getOrderListByUserAndType(user_id, type, page);
		}
		request.setAttribute("orderList", orderList);
		request.setAttribute("title", title);
		return "/mall/jsp/order/orderlist";
	}
	
}
