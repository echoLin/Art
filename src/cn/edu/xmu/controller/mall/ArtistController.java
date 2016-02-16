package cn.edu.xmu.controller.mall;

import javax.annotation.Resource;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.controller.AOP.isArtist;
import cn.edu.xmu.controller.AOP.isUser;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.ArtistService;

/**
 * 
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistMallController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 艺术家控制器
 */

@Controller
public class ArtistController {
	
	@Resource(name="artistService_mall")
	private ArtistService artistService;

/********************************* jump start *****************************/
	/**
	 * 
	 * @Method toApply
	 * @exception 进入申请成为艺术家页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/apply")
	@isUser
	public String toApply(HttpServletRequest request,HttpServletResponse response){
			return "/mall/jsp/artist/apply";
	}
	
	/**
	 * 
	 * @Method jump_verifying
	 * @exception 进入艺术家修改信息页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/verifying")
	@isUser
	public String jump_verifying(HttpServletRequest request,HttpServletResponse response){
		return "/mall/jsp/artist/verifying";
	}
	
	/**
	 * 
	 * @Method jump_applying
	 * @exception 进入艺术家审核状态页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/mall/jsp/artist/applying")
	@isUser
	public String jump_applying(HttpServletRequest request,HttpServletResponse response){
		return "/mall/jsp/artist/applying";
	}
	
	/** 
	 * @Method jump_artist
	 * @exception 进入艺术家主页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/artist/artist")
	@isArtist
	public String jump_artist(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		Artist artist=user.getArtist();
		request.setAttribute("artist", artist);
		return "/mall/jsp/artist/artist";
	}
	
/********************************* jump end *******************************/	
	
/********************************* json start******************************/	
	/**
	 * 
	 * 
	 * @Method commitArtist
	 * @exception 将艺术家的申请信息提交到后台
	 * @param artist 艺术家
	 * @return JSON
	 * @author letitia
	 * @time 2015年12月25日
	 */
	@RequestMapping("/mall/commitArtist.json")
	@ResponseBody
	public JSON commitArtist(Artist artist,HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return artistService.saveArtist(artist,user);	
	}
	/********************************* json end********************************/
}
