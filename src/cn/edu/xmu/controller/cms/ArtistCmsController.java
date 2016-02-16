package cn.edu.xmu.controller.cms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.controller.AOP.isAdmin;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.PUBLIC;
import cn.edu.xmu.service.cms.ArtistService;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistCmsController.java
 * @package cn.edu.xmu.controller.cms
 * @project Art
 * @version 后台艺术家审核控制器
 */
@Controller
public class ArtistCmsController {
	
	@Resource(name="artistService_cms")
	private ArtistService artistService;

/********************************* jump start *****************************/
	
    /**
     * 
     * @Method getArtistList
     * @exception 跳转到艺术家列表
     * @param status 艺术家状态
     * @param page 页码
     * @param request 请求
     * @param response 响应
     * @return
     * @author letitia
     * @time 2015年12月22日
     */
	@RequestMapping("/cms/jsp/artistList")
	@isAdmin(role=PUBLIC.Artist_Auditor)
	public String getArtistList(String status,String page, HttpServletRequest request, HttpServletResponse response){
		int pageNum = artistService.getPageNumByStatus(status);
		List<Artist> list = artistService.getArtistList(status,page);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pageNum", pageNum);
		return "/cms/jsp/artistList";
	}
	
	/**
	 * 
	 * @Method getArtistById
	 * @exception 跳转到艺术家申请详情页面
	 * @param id 艺术家id
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月22日
	 */
	@RequestMapping("/cms/jsp/viewDetailsOfArtists")
	@isAdmin(role=PUBLIC.Artist_Auditor)
	public String getArtistById(String id,HttpServletRequest request, HttpServletResponse response){
		Artist artist = artistService.getArtistById(id);
		request.setAttribute("artist", artist);
		return "/cms/jsp/viewDetailsOfArtists";
		
	}
/********************************* jump end *******************************/
	
/********************************* json start******************************/
	
	/**
	 * 
	 * @Method setArtistStatus
	 * @exception 改变艺术家的审核状态
	 * @param id 艺术家ID
	 * @param status 艺术家状态
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author letitia
	 * @time 2015年12月22日
	 */
	@RequestMapping("/cmsSetArtistStatus.json")
	@ResponseBody
	public JSON setArtistStatus(String id,String status,HttpServletRequest request, HttpServletResponse response){
		return artistService.setArtistStatus(id,status);
	}
	
/********************************* json end********************************/

	

	

}
