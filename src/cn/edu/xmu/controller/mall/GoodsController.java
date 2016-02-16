/**
 * 
 */
package cn.edu.xmu.controller.mall;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.controller.AOP.isArtist;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.ArtmallService;
import cn.edu.xmu.service.mall.ArtworkService;
import cn.edu.xmu.service.mall.ShopService;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ArtworkController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 艺术家管理作品控制器
 */
@Controller
public class GoodsController {
	@Resource(name="artworkService_mall")
	private ArtworkService artworkService;
	@Resource(name="artmallService_mall")
	private ArtmallService artmallService;
	@Resource(name="shopService_mall")
	private ShopService shopService;
	
	
	
	/** 
	 * @Method jump_goodsList
	 * @exception 进入商品管理页面
	 * @param shop_id 店铺ID
	 * @param type 类型
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artist/shop/goods/goodsList")
	@isArtist
	public String jump_goodsList(Long shop_id,Integer type,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		List<Artwork> list = null;
		if(type==null){
			list=artworkService.getArtworkListByShopForArtist(shop);
			type=0;			
		}
		else{
			list=artworkService.getArtworkListByShopAndTypeForArtist(shop,type);
			
		}
		request.setAttribute("list", list);	    
		request.setAttribute("shop", shop);
		request.setAttribute("type", type);
		return "/mall/jsp/artist/shop/goods/goodsList";
	}
	
	
	/** 
	 * @Method jump_lotList
	 * @exception 进入拍卖品管理页面
	 * @param shop_id 店铺ID
	 * @param is_passed 是否通过（1通过 0待审核 -1未通过）
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artist/shop/goods/lotList")
	@isArtist
	public String jump_lotList(Long shop_id,Integer is_passed,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		Shop shop=shopService.getShopByArtistAndShop_idForArtist(artist, shop_id);
		List<Lot> list = null;
		list=artworkService.getLotListByShopAndIsPassedForArtist(shop,is_passed);
		System.out.println(list.size());
		request.setAttribute("list", list);	    
		request.setAttribute("shop", shop);
		request.setAttribute("is_passed", is_passed);
		if(is_passed==1){
			Date current=new Date();
			request.setAttribute("current", current);
		}
		return "/mall/jsp/artist/shop/goods/lotList";
	}
	
	/**
	 * 
	 * @Method jump_lot_apply
	 * @exception 跳转到送拍页面
	 * @param artwork_id 艺术品ID
	 * @param lot_id 竞价品ID
	 * @param request 请求
	 * @param response 相应
	 * @return
	 * @author echo
	 * @time 2016年1月18日
	 */
	@RequestMapping("/mall/jsp/artist/shop/goods/lot_apply")
	@isArtist
	public String jump_lot_apply(Long artwork_id,Long lot_id,HttpServletRequest request, HttpServletResponse response){
		
		if(lot_id==null){
			Artwork artwork=artworkService.getArtworkByIdForArtist(artwork_id);
			request.setAttribute("artwork_id", artwork_id);
			request.setAttribute("shop_id", artwork.getShop().getId());
			request.setAttribute("type", 0);
		}
		if(artwork_id==null)
		{
			Lot lot=artworkService.getLotByIDForArtist(lot_id);
			SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HHmm");
			String start_time=formatter.format(lot.getStart_time());
			String end_time=formatter.format(lot.getEnd_time());
			request.setAttribute("lot", lot);
			request.setAttribute("type", 1);
			request.setAttribute("start_time", start_time);
			request.setAttribute("end_time", end_time);
		}
		return "/mall/jsp/artist/shop/goods/lot_apply";
	}
	
	/********************************JSON*********************************************/

	
	/** 
	 * @Method changeType
	 * @exception 非卖品上架、成品下架
	 * @param artwork_id 艺术品ID
	 * @param type 类型
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/artist/shop/goods/changeType.json")
	@ResponseBody
	public JSON changeType(Long artwork_id,int type,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		return artworkService.saveOrUpdateArtwork(user,artwork_id,type);
	}
	
	/**
	 * 
	 * @Method lotChangeType
	 * @exception 改变竞价品类型
	 * @param lot_id 竞价品ID
	 * @param type 类型
	 * @param request 请求
	 * @param response 响应
	 * @return JSOn
	 * @author echo
	 * @time 2016年1月18日
	 */
	@RequestMapping("/mall/artist/shop/goods/lotChangeType.json")
	@ResponseBody
	public JSON lotChangeType(Long lot_id,int type,HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Lot lot=artworkService.getLotByIDForArtist(lot_id);
		if(lot==null)
			return new JSON(INFO.Error,"该拍卖品不存在");
		Long artwork_id=lot.getArtwork().getId();
		artworkService.deleteLot(lot);
		return artworkService.saveOrUpdateArtwork(user,artwork_id,type);
	}
	/** 
	 * @Method toLot
	 * @exception 送拍
	 * @param artwork_id
	 * @param lot
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @throws ParseException 
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/artist/shop/goods/toLot.json")
	@ResponseBody
	public JSON toLot(Long artwork_id,Lot lot,String start,String end,HttpServletRequest request, HttpServletResponse response) throws ParseException{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HHmm");
		lot.setStart_time(formatter.parse(start));
		lot.setEnd_time(formatter.parse(end));
		return artworkService.toLot(user,lot,artwork_id);
	}
	
	/**
	 * 
	 * @Method updateLot
	 * @exception 更新竞价品内容
	 * @param lot_id 竞价品ID
	 * @param lot 竞价品
	 * @param start 开始竞拍时间
	 * @param end 结束竞拍时间
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @throws ParseException
	 * @author echo
	 * @time 2016年1月18日
	 */
	@RequestMapping("/mall/artist/shop/goods/updateLot.json")
	@ResponseBody
	public JSON updateLot(Long lot_id,Lot lot,String start,String end,HttpServletRequest request, HttpServletResponse response) throws ParseException{
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd'T'HHmm");
		Lot newLot=artworkService.getLotByIDForArtist(lot_id);
		if(newLot==null)
			return new JSON(INFO.Error,"该拍卖品不存在");
		newLot.setPrice(lot.getPrice());
		newLot.setAdd_price(lot.getAdd_price());
		newLot.setStart_time(formatter.parse(start));
		newLot.setEnd_time(formatter.parse(end));
		if(newLot.getIs_passed()==-1)
			newLot.setIs_passed(0);
		return artworkService.saveOrUpdateLot(user,newLot);
	}
}
