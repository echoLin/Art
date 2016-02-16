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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.xmu.controller.AOP.isArtist;
import cn.edu.xmu.controller.AOP.isUser;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.OrderService;
import cn.edu.xmu.service.mall.ShopService;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ShopController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 艺术家管理店铺控制器
 */
@Controller
public class ShopController {
	@Resource(name="shopService_mall")
	private ShopService shopService;
	@Resource(name="orderService_mall")
	private OrderService orderService;
	
	/** 
	 * @Method getShopList
	 * @exception 进入店铺列表页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shopList")
	@isArtist
	public String getShopList(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Integer page = (Integer) (request.getAttribute("page") == null ? 1 : request.getAttribute("page"));
		List<Shop> shopList=shopService.getShopListByArtistForArtist(artist,page);
		request.setAttribute("list", shopList);
		return "/mall/jsp/artist/shopList";
	}
	
	/** 
	 * @Method jump_shopInfo
	 * @exception 进入店铺设置页面
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shopInfo")
	@isArtist
	public String jump_shopInfo(Long id,HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, id);
		request.setAttribute("shop", shop);
		return "/mall/jsp/artist/shop/shopInfo";
	}

	/** 
	 * @Method jump_shopname
	 * @exception 进入修改店铺名字页面
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shop_name")
	@isArtist
	public String jump_shop_name(Long id,HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, id);
		request.setAttribute("shop", shop);
		return "/mall/jsp/artist/shop/shop_name";
	}
	
	/** 
	 * @Method jump_shop_introduction
	 * @exception 进入修改店铺简介页面
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shop_introduction")
	@isArtist
	public String jump_shop_introduction(Long id,HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, id);
		request.setAttribute("shop", shop);
		return "/mall/jsp/artist/shop/shop_introduction";
	}

	/** 
	 * @Method jump_shop_category
	 * @exception 进入修改店铺类型页面
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shop_category")
	@isArtist
	public String jump_shop_category(Long id,HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, id);
		List<Category> list=shopService.getCategoryList();
		request.setAttribute("shop", shop);
		request.setAttribute("list", list);
		return "/mall/jsp/artist/shop/shop_category";
	}
	
	/** 
	 * @Method jump_shop_isCustomized
	 * @exception 进入修改店铺开通定制服务页面
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shop_isCustomized")
	@isArtist
	public String jump_shop_isCustomized(Long id,HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, id);
		request.setAttribute("shop", shop);
		return "/mall/jsp/artist/shop/shop_isCustomized";
	}
	/**
	 * 
	 * @Method toMyshop
	 * @exception 进入我的店铺
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/myshop")
	@isArtist
	public String toMyshop(Long id, HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop = shopService.getShopByArtistAndShop_idForArtist(artist, id);
		request.setAttribute("shop", shop);
		return "/mall/jsp/artist/shop/myshop";
	}
	
	/**
	 * 
	 * @Method jump_shopRegister
	 * @exception 跳转到注册店铺页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shop_register")
	@isArtist
	public String jump_shopRegister(HttpServletRequest request,  HttpServletResponse response){
		return "/mall/jsp/artist/shop/shop_register";
	}
	
	/**
	 * 
	 * @Method toUploadArtwork
	 * @exception 跳转到上传艺术品页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	@RequestMapping("/mall/jsp/artist/shop/uploadArtwork")
	@isArtist
	public String toUploadArtwork(HttpServletRequest request,  HttpServletResponse response){
		String artwork_id = request.getParameter("artwork_id");
		String shop_id = request.getParameter("shop_id");
		if(shop_id != null && (Integer.parseInt(shop_id)!=0 || !shop_id.equals(""))){
			request.setAttribute("shop_id", shop_id);
		}else{
			return "/mall/index";
		}
		if(artwork_id != null && (Integer.parseInt(artwork_id)!=0 || artwork_id.equals(""))){
			request.setAttribute("artwork_id", artwork_id);
			Artwork artwork=shopService.getArtworkByIdForArtist(Long.parseLong(artwork_id));
			request.setAttribute("artwork", artwork);
		}else{
			request.setAttribute("artwork_id", 0);
		}
		return "/mall/jsp/artist/shop/uploadArtwork";
	}
	
	/**
	 * 
	 * @Method shop_avatar
	 * @exception 进入修改店铺头像
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月18日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shopAvatar")
	@isArtist
	public String shop_avatar(String id,HttpServletRequest request,  HttpServletResponse response){
		String shop_id = id;
		if(shop_id != null && (Integer.parseInt(shop_id)!=0 || !shop_id.equals(""))){
			request.setAttribute("shop_id", shop_id);
		}else{
			return "/mall/index";
		}
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shopAvatar";
	}
	
	
	/************************************JSON*****************************************/
	
	/** 
	 * @Method shopRegister
	 * @exception 店铺注册
	 * @param shop 店铺
	 * @param request 请求
	 * @return JSON
	 * @author Qing
	 * @time 2015年12月24日
	 */
	@RequestMapping("/mall/artist/shop/shop_register.json")
	@ResponseBody
	public JSON shopRegister(Shop shop,Long category_id,HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		return shopService.saveOrUpdateShop(shop,category_id,user);
	}
	
	/**
	 * 
	 * @Method uploadArtwork
	 * @exception 进入更新艺术品页面
	 * @param artwork 艺术品
	 * @param shop_id 店铺ID
	 * @param category_id 分类ID
	 * @return JSON
	 * @author echo
	 * @time 2015年12月26日
	 */
	@RequestMapping("/mall/saveArtwork.json")
	@ResponseBody
	public JSON uploadArtwork(Artwork artwork, Long shop_id, Long category_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user =(User) session.getAttribute("user");
		return shopService.saveOrUpdateArtwork(artwork, shop_id, category_id, user);
	}
	
	/**
	 * 
	 * @Method getCategoryList
	 * @exception 获取分类列表
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月26日
	 */
	@RequestMapping("/getCategoryList.json")
	@ResponseBody
	public JSON getCategoryList(HttpServletRequest request, HttpServletResponse response){
		return new JSON(INFO.Success,shopService.getCategoryList());
	}
	
	/**
	 * 
	 * @Method uploadArtworkImg
	 * @exception 上传艺术品图片
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月26日
	 */
	@RequestMapping("/mall/uploadArtworkImg.json")
	@ResponseBody
	public JSON uploadArtworkImg(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		MultipartFile file = multipartRequest.getFile("file_data"); 
		return shopService.addArtworkImg(file, user);
	}
	
	/** 
	 * @Method modify_shop_name
	 * @exception 修改店铺名称
	 * @param new_name 店铺名字
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author Qing
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/artist/shop/shop_name.json")
	@ResponseBody
	public JSON modify_shop_name(String new_name,Long shop_id,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		if(shop==null)
			return new JSON(INFO.Error,"该店铺不存在");
		shop.setName(new_name);
		if(shopService.saveOrUpdateShop(shop)){
			return new JSON(INFO.Success,shop.getId());
		}
		else{
			return new JSON(INFO.Error,"修改失败");
		}
		
	}

	/** 
	 * @Method modify_shop_introduction
	 * @exception 修改店铺介绍
	 * @param new_introduction 店铺结束
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author Qing
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/artist/shop/shop_introduction.json")
	@ResponseBody
	public JSON modify_shop_introduction(String new_introduction,Long shop_id,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		if(shop==null)
			return new JSON(INFO.Error,"该店铺不存在");
		shop.setIntroduction(new_introduction);
		if(shopService.saveOrUpdateShop(shop)){
			return new JSON(INFO.Success,shop.getId());
		}
		else{
			return new JSON(INFO.Error,"修改失败");
		}
		
	}
	
	/** 
	 * @Method modify_shop_isCustomized
	 * @exception 修改店铺开通定制服务
	 * @param new_isCustomized 是否定制
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author Qing
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/artist/shop/shop_isCustomized.json")
	@ResponseBody
	public JSON modify_shop_isCustomized(Integer new_isCustomized,Long shop_id,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null)
			return new JSON(INFO.NotLogin,INFO.LoginMALL);
		Artist artist=user.getArtist();
		if(artist==null)
			return new JSON(INFO.JumpTo,INFO.ApplyArtist);
		if(artist.getStatus()==0)
			return new JSON(INFO.JumpTo,INFO.Applying);
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		if(shop==null)
			return new JSON(INFO.Error,"该店铺不存在");
		shop.setIs_customized(new_isCustomized);
		if(shopService.saveOrUpdateShop(shop)){
			return new JSON(INFO.Success,shop.getId());
		}
		else{
			return new JSON(INFO.Error,"修改失败");
		}
		
	}
	
	/** 
	 * @Method saveAvator
	 * @exception 上传店铺头像
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author Qing
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/artist/shop/shop_avatar.json")
	@ResponseBody
	public JSON saveAvator(Long shop_id,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		MultipartFile file = multipartRequest.getFile("avatar"); 
        //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹   
        return shopService.saveAvatar(file, user,shop_id);
	}
	
	
	/**
	 * 
	 * @Method toOrder
	 * @exception 进入订单管理页面
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping(value={"/mall/jsp/artist/shop/shoporder/shoporder","/mall/jsp/shoporder"})
	@isUser
	public String toOrder(Long shop_id,HttpServletRequest request, HttpServletResponse response){
		System.out.println("in");
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shoporder/shoporder";
	}

	/**
	 * 
	 * @Method toCustomizationOrder
	 * @exception 进入定制订单列表页面
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping(value={"/mall/jsp/artist/shop/shoporder/customizationOrder","/mall/jsp/customizationorder"})
	@isUser
	public String toCustomizationOrder(Long shop_id,HttpServletRequest request, HttpServletResponse response){
		System.out.println("in");
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shoporder/customizationOrder";
	}
	
	/**
	* @Method toOrderDetail
	* @exception 进入订单详情页面
	* @param id 订单ID
	* @param user_id 用户ID
	* @param request 请求
	* @param response 响应
	* @return 订单类
	* @author weltion
	* @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/orderdetail")
	@isUser
	public String toOrderDetail(Long id,Long shop_id,HttpServletRequest request, HttpServletResponse response){
	
		//返回订单详情
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		
		Order order = orderService.getOrderByIdAndShop(id, shop);	
		
		String Type_title;
		
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
		
		//确认发货按钮
		String button_edit_express = new String(
				"<div class=\"go_buy\" style=\"margin-top 5px;\"><a href=\"/Art/mall/jsp/artist/shop/shoporder/editexpress?value="
				+order.getTracking_number()
				+"&id="
				+order.getId().toString()
				+"&shop_id="
				+shop_id
				+"\" >确认发货</a></div>"
		);
		
		//修改价格按钮
		String button_edit_price= new String(
				"<div class=\"go_buy\"  style=\"margin-top 5px\"><a href=\"/Art/mall/jsp/artist/shop/shoporder/editprice?value="
				+order.getArtwork().getPrice()
				+"&id="
				+order.getId().toString()
				+"&shop_id="
				+shop_id
				+"\">修改价格</a></div>"
		);
		
		//定制阶段按钮
		String button_set_payments= new String(
				"<div class=\"go_buy\"  style=\"margin-top 5px\" >"
				+"<a href=\"/Art/mall/jsp/artMall/shop/customization?order_id="
				+order.getId()
				+"&shop_id="
				+shop_id
				+"\">定制阶段</a></div>"
		);
		
		if(order.getType() == 3 ){//待付款订单，也就是购买订单
			request.setAttribute("button_edit_price", button_edit_price);
			request.setAttribute("button_set_payments", button_set_payments);
		}
		else if(order.getStatus()==1){//待发货订单
			request.setAttribute("button_edit_price", button_edit_price);
		}
		else if(order.getStatus()==2){
			String stage="1";
			request.setAttribute("button_edit_express", button_edit_express);
			
		}
		
		request.setAttribute("order", order);
		return "/mall/jsp/artist/shop/shoporder/orderdetail";

		
		
	}
	
	
	
	
	/**
	* @Method toOrderList
	* @exception 返回阶段列表
	* @param user_id 用户ID
	* @param status 状态
	* @param request 请求
	* @param response 响应
	* @return String
	* @author Weltion
	* @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/artMall/shop/customization")
	@isArtist
	public String toPaymentList(Long order_id,Long shop_id,HttpServletRequest request,
			HttpServletResponse response){

		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);

		Order order = null;
		
		order = orderService.getOrderByIdAndShop(order_id, shop);

		List<Payment> paymentList = null;
		
		paymentList = orderService.getPaymentListByOrderAndTo(order, user);
		System.out.println(paymentList);
		request.setAttribute("paymentList", paymentList);
		request.setAttribute("order_id", order_id);
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artMall/shop/customization";
	}
	
	
	
	/**
	* @Method toOrderList
	* @exception 返回订单列表
	* @param user_id 用户ID
	* @param status 状态
	* @param request 请求
	* @param response 响应
	* @return String
	* @author Weltion
	* @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/orderlist")
	@isArtist
	public String toOrderList(Long shop_id,Integer type,Integer status,Integer page,HttpServletRequest request,
			HttpServletResponse response){

		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		
		
		List<Order> orderList = null;
		
		String title=null;
		String Status_title=null;
		String Type_title=null;
		
		if(type!=3){//非订制品
			if( status ==1 ){
				title = "待支付订单";
				Status_title = "待确认";
			}
			else if(status ==2){
				title = "待发货订单";
				Status_title = "待发货";
			}
			else if(status ==3){
				title = "已发货订单";
				Status_title = "运途中";
			}
			else if(status ==5){
				title = "历史订单";
				Status_title = "已评价";
			}
			orderList = orderService.getOrderListByShopAndStatus(shop, status, page);
		}else if(type==3){//完成首付的订制品
			
			if(status == 1){
				title = "未首付订单";
				Status_title = "未首付";
				
			}else if(status ==2){
				title = "已首付订单";
				Status_title = "已首付";
			}
			else if(status ==3){
				title = "已完成订单";
				Status_title = "已完成";
			}
			else if(status ==5){
				title = "已交付订单";
				Status_title = "已交付";
			}
			orderList = orderService.getOrderListByTypeAndShopAndStatus(type, shop, status, page);
			System.out.println("asda dasd assd");
		}
		request.setAttribute("orderList", orderList);
		request.setAttribute("title", title);
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shoporder/orderlist";
	}
	
	
	
	
	/**
	 * 
	 * @Method toEditOrderPrice
	 * @exception 修改订单价格
	 * @param value 价格
	 * @param id 订单价格
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/editprice")
	@isUser
	public String toEditOrderPrice(String value,Long id,Long shop_id,HttpServletRequest request,
			HttpServletResponse response){
		request.setAttribute("value", value);
		request.setAttribute("id", id);
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shoporder/editprice";
	}
	
	
	
	
	/**
	 * 
	 * @Method modify_price
	 * @exception 修改卖品价格
	 * @param new_price 新价格
	 * @param id 卖品价格
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/modify_price.json")
	@ResponseBody
	public JSON modify_price(double new_price,Long id,Long shop_id,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);

		Order order = null;
		order = orderService.getOrderByIdAndShop(id, shop);	
		order.setExpress_company("zhongtongkuaidi");

		System.out.println(id);
		return orderService.saveOrUpdateOrder(order);
	}
	
	
	
	
	
	/**
	 * 
	 * @Method toEditOrderExpress
	 * @exception 填写订单快递
	 * @param value 价格
	 * @param id 订单ID
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/editexpress")
	@isUser
	public String toEditOrderExpress(String value,Long id,Long shop_id, HttpServletRequest request,
			HttpServletResponse response){
		request.setAttribute("value", value);
		request.setAttribute("id", id);
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artist/shop/shoporder/editexpress";
	}
	
	
	
	
	/**
	 * 
	 * @Method modify_express
	 * @exception 修改快递
	 * @param express_company 快递公司
	 * @param tracking_number 运单号
	 * @param id 订单ID
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/modify_express.json")
	@ResponseBody
	public JSON modify_express(String express_company,String tracking_number,Long id,Long shop_id,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
	
		Order order = null;
		order = orderService.getOrderByIdAndShop(id, shop);
		
		order.setExpress_company(express_company);
		order.setTracking_number(tracking_number);
		order.setStatus(3);
		
		
		return orderService.saveOrUpdateOrder(order);
	}
	
	
	
	
	/**
	 * 
	 * @Method toCommitOrder
	 * @exception 进入订单确认界面
	 * @param value 订单价格
	 * @param id 订单ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/commitorder")
	@isUser
	public String toCommitOrder(String value,Long id, HttpServletRequest request,
			HttpServletResponse response){
		request.setAttribute("value", value);
		request.setAttribute("id", id);
		return "/mall/jsp/artist/shop/shoporder/commitorder";
	}
	
	
	
	
	/**
	 * 
	 * @Method commit_order
	 * @exception 确认订单
	 * @param id 订单ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/commit_order.json")
	@ResponseBody
	public JSON commit_order(Long id,HttpServletRequest request,HttpServletResponse response){
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		Long user_id = user.getUserid();
		System.out.println(user);

		Order order = null;
		order = orderService.getOrderByIdAndUser(id, user_id);		
		order.setStatus(2);

		System.out.println("订单确认成功！");
		return orderService.saveOrUpdateOrder(order);
	}
	
	
	/**
	 * 
	 * @Method addpayment
	 * @exception 填写定制订单的增加阶段内容
	 * @param order_id 订单ID
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/shop/addpayment")
	@isUser
	public String addpayment(Long order_id,Long shop_id, HttpServletRequest request,
			HttpServletResponse response){
		request.setAttribute("order_id", order_id);
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/artMall/shop/addpayment";
	}
	
	
	/**
	 * 
	 * @Method add_payment
	 * @exception 定制订单增加定制阶段
	 * @param mark 标记
	 * @param price 价格
	 * @param order_id 订单ID
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @throws Exception
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/shop/shoporder/add_payment.json")
	@ResponseBody
	public int add_payment(
			String mark,
			Double price,
			Long order_id,
			Long shop_id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);

		Order order = null;
		
		order = orderService.getOrderByIdAndShop(order_id, shop);

		System.out.println("payment添加成功！");
		
		Payment payment = new Payment();
		
		payment.setFrom(order.getUser());
		payment.setTo(user);
		payment.setPrice(price);
		payment.setIs_pay(1);
		payment.setOrder(order);
		orderService.saveOrUpdatePayment(payment);
		
		return 1;
	}
	



}
