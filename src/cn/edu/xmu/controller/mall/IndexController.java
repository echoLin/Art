package cn.edu.xmu.controller.mall;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;
import cn.edu.xmu.service.mall.IndexService;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file IndexController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 首页，资讯控制器
 */
@Controller
public class IndexController {
	
	@Resource(name="indexService_mall")
	private IndexService indexService;
	
/********************************* jump start *****************************/
	
	/**
	 * 
	 * @Method toIndex
	 * @exception 进入首页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	@RequestMapping("/mall/index")
	public String toIndex(HttpServletRequest request, HttpServletResponse response){
		List<Article> carouselList = indexService.getArticleList(1);//首页轮播
		List<Article> hotList = indexService.getArticleList(2);//首页热门
		
		request.setAttribute("carouselList", carouselList);
		request.setAttribute("hotList", hotList);
		return "/mall/index";
	}
	
	/**
	 * 
	 * @Method toNewsList
	 * @exception 获取资讯列表
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	@RequestMapping("/mall/jsp/newsList")
	public String toNewsList(HttpServletRequest request, HttpServletResponse response){
		List<Block> blockList = indexService.getBlockList();
		request.setAttribute("blockList", blockList);
		@SuppressWarnings("rawtypes")
		List<List> list = new ArrayList<List>();
		for(int i = 0; i<blockList.size(); i++){
			list.add(indexService.getArticleList(blockList.get(i).getId()));
		}
		request.setAttribute("list", list);
		return "/mall/jsp/newsList";
	}
	
	/**
	 * 
	 * @Method toNews
	 * @exception 进入资讯详情
	 * @param id 资讯ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	@RequestMapping("/mall/jsp/news")
	public String toNews(String id, HttpServletRequest request, HttpServletResponse response){
		Article article = indexService.getArticleById(id);
		request.setAttribute("article", article);
		return "/mall/jsp/news";
	}
	
/********************************* jump end *******************************/

	
}
