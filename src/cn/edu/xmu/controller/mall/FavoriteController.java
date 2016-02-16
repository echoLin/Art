/**
 * @Title {filename}
 * @Package cn.edu.xmu.controller.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月27日 下午94715
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

import cn.edu.xmu.controller.AOP.isUser;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.FavoriteService;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file FavoriteController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 收藏夹控制器
 */
@Controller
public class FavoriteController {
	@Resource(name="favoriteService_mall")
	private FavoriteService favoriteService;
	
/********************************* jump start *****************************/
	/**
	 * 
	 * @Method toFavorite
	 * @exception 进入收藏页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping(value={"/mall/jsp/favorite","/Art/mall/jsp/favorite/index"})
	@isUser
	public String toFavorite(HttpServletRequest request, HttpServletResponse response){
		return "/mall/jsp/favorite/index";
	}
	
	/**
	 * 
	 * @Method toFavoriteArtistList
	 * @exception 获取收藏的艺术家
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/favorite/artistList")
	@isUser
	public String toFavoriteArtistList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("favoriteList", favoriteService.getFavoriteList(user, 1, 1).getData());
		return "/mall/jsp/favorite/artistList";
	}
	
	/**
	 * 
	 * @Method toFavoriteShopList
	 * @exception 获取收藏的店铺
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/favorite/shopList")
	@isUser
	public String toFavoriteShopList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("favoriteList", favoriteService.getFavoriteList(user, 1, 2).getData());
		return "/mall/jsp/favorite/shopList";
	}
	
	/**
	 * 
	 * @Method toFavoriteArtworkList
	 * @exception 获取收藏的艺术品
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/favorite/artworkList")
	@isUser
	public String toFavoriteArtworkList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("favoriteList", favoriteService.getFavoriteList(user, 1, 3).getData());
		return "/mall/jsp/favorite/artworkList";
	}
	
/********************************* jump start *****************************/
/********************************* json start *****************************/
	/**
	 * 
	 * @Method getFavoriteList
	 * @exception 获取更多收藏
	 * @param page 页码
	 * @param type 类型（1.艺术家 2.店铺 3.艺术品）
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mallGetFavoriteList.json")
	@ResponseBody
	public JSON getFavoriteList(Integer page, Integer type, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.getFavoriteList(user, page, type);
	}
	
	/**
	 * 
	 * @Method setFavoriteArtist
	 * @exception 收藏艺术家
	 * @param artist 艺术家
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/setFavoriteArtist.json")
	@ResponseBody
	public JSON setFavoriteArtist(Artist artist, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.setFavorite(user, artist);
	}
	
	/**
	 * 
	 * @Method setFavoriteArtwork
	 * @exception 收藏艺术品
	 * @param artwork 艺术品
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/setFavoriteArtwork.json")
	@ResponseBody
	public JSON setFavoriteArtwork(Artwork artwork, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.setFavorite(user, artwork);
	}
	
	/**
	 * 
	 * @Method setFavoriteShop
	 * @exception 收藏店铺
	 * @param shop 店铺
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/setFavoriteShop.json")
	@ResponseBody
	public JSON setFavoriteShop(Shop shop, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.setFavorite(user, shop);
	}
	
	/**
	 * 
	 * @Method unFavoriteArtwork
	 * @exception 取消收藏艺术品
	 * @param artwork 艺术品
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/unFavoriteArtwork.json")
	@ResponseBody
	public JSON unFavoriteArtwork(Artwork artwork, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.deleteFavorite(user, artwork);
	}
	
	/**
	 * 
	 * @Method unFavoriteArtist
	 * @exception 取消收藏艺术家
	 * @param artist 艺术家
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/unFavoriteArtist.json")
	@ResponseBody
	public JSON unFavoriteArtist(Artist artist, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.deleteFavorite(user, artist);
	}
	
	/**
	 * 
	 * @Method unFavoriteShop
	 * @exception 取消收藏店铺
	 * @param shop 店铺
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/unFavoriteShop.json")
	@ResponseBody
	public JSON unFavoriteShop(Shop shop, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return favoriteService.deleteFavorite(user, shop);
	}
	
/********************************* json start *****************************/	

}
