package cn.edu.xmu.controller.cms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.controller.AOP.isAdmin;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.PUBLIC;
import cn.edu.xmu.service.cms.CategoryService;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file CategoryController.java
 * @package cn.edu.xmu.controller.cms
 * @project Art
 * @exception 分类管理控制器
 */

@Controller
public class CategoryController {
	
	@Resource(name="categoryService_cms")
	private CategoryService categoryService;
	
	/********************************* jump start *****************************/
	
	/**
	 * 
	 * @Method getCategoryList
	 * @exception 获取分类列表
	 * @param page 页码
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cms/jsp/categoryList")
	@isAdmin(role=PUBLIC.Category_Manager)
	public String getCategoryList(String page,HttpServletRequest request, HttpServletResponse response){
		int pageNum = categoryService.getCategoryPageNum();
		List<Category> list = categoryService.getCategoryList(page);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("pageNum", pageNum);
		return "/cms/jsp/categoryList";
	}
	
	/********************************* jump end *******************************/
	
	/********************************* json start******************************/
	
	/**
	 * 
	 * @Method addCategory
	 * @exception 添加分类
	 * @param category 类别
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cms/categpry.json")
	@ResponseBody
	public JSON addCategory(String category,HttpServletRequest request, HttpServletResponse response){
        return categoryService.addCategory(category);
	}
	
	/********************************* json end********************************/

}
