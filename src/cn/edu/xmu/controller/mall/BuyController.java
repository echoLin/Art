/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月30日 下午84111
 * @version V1.0
 */
package cn.edu.xmu.controller.mall;

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
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.BuyService;
import cn.edu.xmu.service.mall.ShopService;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BuyController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 交易Controller
 */
@Controller
public class BuyController {
	@Resource(name="buyService_mall")
	private BuyService buyService;
	@Resource(name="shopService_mall")
	private ShopService shopService;
	
	/**
	 * 
	 * @Method toCreateOrder
	 * @exception 创建订单
	 * @param artwork_id 艺术品ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/createOrder")
	@isUser
	public String toCreateOrder(Long artwork_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("artwork", buyService.getArtworkById(artwork_id));
		if(user != null){
			request.setAttribute("address", user.getAddress());
		}
		request.setAttribute("addressList", buyService.getAddressListByUser(user));
		return "/mall/jsp/buy/createOrder";
	}
	
	/**
	 * 
	 * @Method toConfirmCustomOrder
	 * @exception 确认生成定制订单
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/confirmCustomOrder")
	@isUser
	public String toConfirmCustomOrder(Long shop_id, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("shop", buyService.getShopById(shop_id));
		return "/mall/jsp/buy/confirmCustomOrder";
	}
	
	/**
	 * 
	 * @Method toCreateCustomizedOrder
	 * @exception 进入生成定制订单
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/customizationPage")
	@isUser
	public String toCreateCustomizedOrder(Long shop_id, HttpServletRequest request, HttpServletResponse response){
		if(shop_id == null || shop_id == 0){
			return "/mall/index";
		}
		request.setAttribute("shop_id", shop_id);
		return "/mall/jsp/buy/customizationPage";
	}
	
	/**
	 * 
	 * @Method toPay
	 * @exception 进入付款页面
	 * @param payment_id 代付款记录ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/pay")
	@isUser
	public String toPay(Long payment_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Payment payment = buyService.getPaymentById(payment_id, user);
		request.setAttribute("payment", payment);
		return "/mall/jsp/buy/pay";
	}
	
	/**
	 * 
	 * @Method toPaySuccess
	 * @exception 进入付款成功页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/paySuccess")
	@isUser
	public String toPaySuccess(HttpServletRequest request, HttpServletResponse response){
		return "/mall/jsp/buy/paySuccess";
	}
	
	/**
	 * 
	 * @Method toDeposit
	 * @exception 进入交押金页面
	 * @param lot_id 竞价品ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/mall/jsp/buy/deposit")
	@isUser
	public String toDeposit(Long lot_id, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("lot", buyService.getLotById(lot_id));
		return "/mall/jsp/buy/deposit";
	}
	
	/**
	 * 
	 * @Method createOrder
	 * @exception 生成订单JSON
	 * @param artwork_id 艺术品ID
	 * @param address_id 送货定制ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/createOrder.json")
	@ResponseBody
	public JSON createOrder(Long artwork_id, Long address_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return buyService.createOrder(artwork_id, address_id, user);
	}
	
	/**
	 * 
	 * @Method pay
	 * @exception 付款JSON
	 * @param payment_id 代付款ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/pay.json")
	@ResponseBody
	public JSON pay(Long payment_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return buyService.setPay(payment_id, user);
	}
	
	/**
	 * 
	 * @Method saveCustomOrder
	 * @exception 保存定制订单JSON
	 * @param artwork 艺术品
	 * @param category_id 分类ID
	 * @param shop_id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/saveCustomOrder.json")
	@ResponseBody
	public JSON saveCustomOrder(Artwork artwork, Long category_id, Long shop_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return buyService.saveCustomOrder(artwork, category_id, shop_id, user);
	}
	
	/**
	 * 
	 * @Method payDeposit
	 * @exception 付押金JSON
	 * @param lot_id 竞价品ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/deposit.json")
	@ResponseBody
	public JSON payDeposit(Long lot_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return buyService.createDeposit(lot_id, user);
	}
	
	/**
	 * 
	 * @Method bid
	 * @exception 叫价JSON
	 * @param lot_id 竞价品ID
	 * @param money 出价
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月31日
	 */
	@RequestMapping("/bid.json")
	@ResponseBody
	public JSON bid(Long lot_id, Double money, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return buyService.createBid(lot_id, money, user);
	}
	
	
	/**
	 * 
	 * @Method toCustomizationPage
	 * @exception 进入定制订单要求填写页面
	 * @param shop_id 店铺ID
	 * @param artwork_id 艺术品ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/shop/customizationPage")
	@isUser
	public String toCustomizationPage(String shop_id,String artwork_id,HttpServletRequest request,  HttpServletResponse response){

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
		return "/mall/jsp/artMall/shop/customizationPage";
	}
	
	
	
	/**
	 * 
	 * @Method saveCustomization
	 * @exception 保存定制订单要求JSON
	 * @param artwork 艺术品
	 * @param shop_id 店铺ID
	 * @param category_id 分类ID
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/saveCustomization.json")
	@ResponseBody
	public JSON saveCustomization(Artwork artwork, Long shop_id, Long category_id, HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user =(User) session.getAttribute("user");
		System.out.println(user);
		System.out.println(artwork);
		artwork.setContent("测试数据是否到数据库！");
		return shopService.saveOrUpdateArtwork(artwork, shop_id, category_id, user);
	}
	

}
