package cn.edu.xmu.controller.mall;

import java.util.List;

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
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.ArtmallService;
import cn.edu.xmu.service.mall.FavoriteService;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtmallController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 商城控制器
 */
@Controller
public class ArtmallController {
	@Resource(name="artmallService_mall")
	private ArtmallService artmallService;
	@Resource(name="favoriteService_mall")
	private FavoriteService favoriteService;
	

/********************************* jump start *****************************/
	
	/**
	 * 
	 * @Method toIndex
	 * @exception 进入首页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall")
	public String toIndex(HttpServletRequest request, HttpServletResponse response){
		return "redirect/mall/index";
	}
	
	/**
	 * 
	 * @Method toArtMallIndex
	 * @exception 进入商城首页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall")
	public String toArtMallIndex(HttpServletRequest request, HttpServletResponse response){
		//返回分类数组
		List<Category> categoryList = artmallService.getCategoryList();
		request.setAttribute("categoryList", categoryList);
		return "/mall/jsp/artMall";
	}
	
	/**
	 * 
	 * @Method toArtistList
	 * @exception 进入艺术家列表
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artistList")
	public String toArtistList(Boolean isHot, Integer page, HttpServletRequest request, HttpServletResponse response){
		//返回艺术家数组
		request.setAttribute("artistList", artmallService.getArtistList(page, isHot));
		return "/mall/jsp/artMall/artistList";
	}
	
	/**
	 * 
	 * @Method toArtworkList
	 * @exception 进入作品列表
	 * @param category_id 分类ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artworkList")
	public String toArtworkList(Long category_id, Integer page, Boolean isHot, HttpServletRequest request, HttpServletResponse response){
		//返回艺术成品数组
		request.setAttribute("artworkList", artmallService.getArtworkListByCategoryAndType(category_id, 2, page, isHot));
		return "/mall/jsp/artMall/artworkList";
	}
	
	/**
	 * 
	 * @Method toShopList
	 * @exception 进入店铺列表
	 * @param category_id 分类ID
	 * @param page 页码
	 * @param isHot 是否热门（1热门）
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/shopList")
	public String toShopList(Long category_id, Integer isCus, Integer page, Boolean isHot, HttpServletRequest request, HttpServletResponse response){
		//返回店铺数组
		request.setAttribute("shopList", artmallService.getShopListByCategoryAndIsCus(category_id, isCus, page, isHot));
		return "/mall/jsp/artMall/shopList";
	}
	
	/**
	 * 
	 * @Method toLotList
	 * @exception 进入竞价列表
	 * @param category_id 分类ID
	 * @param time 开拍时间（正在进行 1， 将来进行2）
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/lotList")
	public String toLotList(Long category_id, Integer time, Integer page, HttpServletRequest request, HttpServletResponse response){
		//返回拍卖的艺术品数组
		request.setAttribute("lotList", artmallService.getLotListByCategoryAndTime(category_id, time, page));
		return "/mall/jsp/artMall/lotList";
	}
	
	/**
	 * 
	 * @Method toArtworkInfo
	 * @exception 进入艺术品详情
	 * @param id 艺术品ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artworkInfo")
	public String toArtworkInfo(Long id, String artist,HttpServletRequest request, HttpServletResponse response){
		//返回艺术品详情
		Artwork artwork = artmallService.getArtworkById(id);
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			artwork.setFavorite((boolean)favoriteService.hasFavorite((User)session.getAttribute("user"), artwork).getData());
		}
		request.setAttribute("artwork", artwork);
		if(artist==null)
			request.setAttribute("artist", false);
		else
			request.setAttribute("artist", true);
		
		return "/mall/jsp/artMall/artworkInfo";
	}
	
	/**
	 * 
	 * @Method toArtistInfo
	 * @exception 进入艺术家主页
	 * @param id 艺术家ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artistInfo")
	public String toArtistInfo(Long id, HttpServletRequest request, HttpServletResponse response){
		//返回艺术家个人信息
		Artist artist = artmallService.getArtistById(id);
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			artist.setFavorite((boolean)favoriteService.hasFavorite((User)session.getAttribute("user"), artist).getData());
		}
		request.setAttribute("artist", artist);
		return "/mall/jsp/artMall/artistInfo";
	}
	
	/**
	 * 
	 * @Method toShopInfo
	 * @exception 进入店铺详情
	 * @param id 店铺ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/shopInfo")
	public String toShopInfo(Long id, HttpServletRequest request, HttpServletResponse response){
		Shop shop = artmallService.getShopById(id);
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null){
			shop.setFavorite((boolean)favoriteService.hasFavorite((User)session.getAttribute("user"), shop).getData());
		}
		request.setAttribute("shop", shop);
		return "/mall/jsp/artMall/shopInfo";
	}
	
	/**
	 * 
	 * @Method toArtistIntroduction
	 * @exception 进入艺术家介绍
	 * @param id 艺术家ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artist/introduction")
	public String toArtistIntroduction(Long id, HttpServletRequest request, HttpServletResponse response){
		Artist artist = artmallService.getArtistById(id);
		request.setAttribute("introduction", artist.getIntroduction());
		return "/mall/jsp/artMall/artist/introduction";
	}
	
	/**
	 * 
	 * @Method toArtistShopList
	 * @exception 进入艺术家店铺列表
	 * @param artist 艺术家
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artist/shopList")
	public String toArtistShopList(Artist artist, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("shopList", artmallService.getShopListByArtist(artist, 1));
		return "/mall/jsp/artMall/artist/shopList";
	}
	
	/**
	 * 
	 * @Method toArtistArtworkList
	 * @exception 进入艺术家作品列表
	 * @param artist 艺术家
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/artMall/artist/artworkList")
	public String toArtistArtworkList(Artist artist, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("artworkList", artmallService.getArtworkListByArtist(artist, 1));
		return "/mall/jsp/artMall/artist/artworkList";
	}
	
	/**
	 * 
	 * @Method toShopArtworkList
	 * @exception 进入店铺作品列表
	 * @param id 店铺ID
	 * @param type 艺术品类型
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	@RequestMapping("/mall/jsp/artMall/shop/artworkList")
	public String toShopArtworkList(Long id, Integer type, Integer page, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("list", artmallService.getArtworkListByShop(id, type, page));
		request.setAttribute("type", type);
		return "/mall/jsp/artMall/shop/artworkList";
	}
	
	/**
	 * 
	 * @Method toLotInfo
	 * @exception 进入竞价商品详情
	 * @param id 竞价品ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	@RequestMapping("/mall/jsp/artMall/lotInfo")
	public String toLotInfo(Long id, HttpServletRequest request, HttpServletResponse response){
		request.setAttribute("lot", artmallService.getLotById(id));
		return "/mall/jsp/artMall/lotInfo";
	}
	
/********************************* jump end *******************************/
	
/********************************* json start******************************/
	
	/**
	 * 
	 * @Method getMoreArtistForArtMall
	 * @exception 获取更多艺术家
	 * @param page 页码
	 * @param isHot 是否热门（1热门）
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/getMoreArtist.json")
	@ResponseBody
	public JSON getMoreArtistForArtMall(Integer page, Boolean isHot, HttpServletRequest request, HttpServletResponse response){
		//返回艺术家数组
		return new JSON(INFO.Success, artmallService.getArtistList(page, isHot));
	}
	
	/**
	 * 
	 * @Method getMoreArtworkForArtMall
	 * @exception 获取更多作品
	 * @param category_id 分类ID
	 * @param page 页码
	 * @param isHot 是否热门
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/getMoreArtwork.json")
	@ResponseBody
	public JSON getMoreArtworkForArtMall(Long category_id, Integer page, Boolean isHot, HttpServletRequest request, HttpServletResponse response){
		//返回艺术成品数组
		return new JSON(INFO.Success, artmallService.getArtworkListByCategoryAndType(category_id, 2, page, isHot));
	}
	
	/**
	 * 
	 * @Method getMoreShopForArtMall
	 * @exception 获取更多店铺
	 * @param category_id 分类ID
	 * @param isCus 是否提供定制（1 提供定制； -1 不提供定制）
	 * @param page
	 * @param isHot
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/getMoreShop.json")
	@ResponseBody
	public JSON getMoreShopForArtMall(Long category_id, Integer isCus, Integer page, Boolean isHot, HttpServletRequest request, HttpServletResponse response){
		//返回艺术成品数组
		return new JSON(INFO.Success, artmallService.getShopListByCategoryAndIsCus(category_id, isCus, page, isHot));
	}
	
	/**
	 * 
	 * @Method getMoreLotForArtMall
	 * @exception 获取更多竞价商品
	 * @param category_id 分类ID
	 * @param time 竞价是否开始（1开始 2 未开始）
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artMall/getMoreLot.json")
	@ResponseBody
	public JSON getMoreLotForArtMall(Long category_id, Integer time, Integer page, HttpServletRequest request, HttpServletResponse response){
		//返回拍卖品数组
		return new JSON(INFO.Success, artmallService.getLotListByCategoryAndTime(category_id, time, page));
	}
	
	/**
	 * 
	 * @Method getMoreArtworkForShop
	 * @exception 获取该店铺的更多作品
	 * @param id 店铺ID
	 * @param type 艺术品类型
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mallGetMoreShopArtwork.json")
	@ResponseBody
	public JSON getMoreArtworkForShop(Long id, Integer type, Integer page, HttpServletRequest request, HttpServletResponse response){
		//返回艺术品数组
		return new JSON(INFO.Success, artmallService.getArtworkListByShop(id, type, page));
	}
	
	/**
	 * 
	 * @Method getMoreShopListByArtist
	 * @exception 获取该艺术家的更多店铺
	 * @param artist 艺术家
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mallGetMoreShopListByArtist.json")
	@ResponseBody
	public JSON getMoreShopListByArtist(Artist artist, Integer page, HttpServletRequest request, HttpServletResponse response){
		return new JSON(INFO.Success, artmallService.getShopListByArtist(artist, page));
	}
	
	/**
	 * 
	 * @Method getMoreArtworkListByArtist
	 * @exception 获取该艺术家的更多作品
	 * @param artist 艺术家
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mallGetMoreArtworkListByArtist.json")
	@ResponseBody
	public JSON getMoreArtworkListByArtist(Artist artist, Integer page, HttpServletRequest request, HttpServletResponse response){
		return new JSON(INFO.Success, artmallService.getArtworkListByArtist(artist, page));
	}
	
/********************************* json end******************************/
}
