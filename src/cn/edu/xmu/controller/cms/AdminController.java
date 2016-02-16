package cn.edu.xmu.controller.cms;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.xmu.service.cms.AdminService;
import cn.edu.xmu.controller.AOP.isAdmin;
import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Auth;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AdminController.java
 * @package cn.edu.xmu.controller.cms
 * @project Art
 * @version 后台登陆权限控制器
 * @author echo
 */
@Controller
public class AdminController {
	
	@Resource(name="adminService_cms")
	private AdminService adminService;
	
/********************************* jump start *****************************/
	
	/**
	 * 	
	 * @Method toLogin
	 * @exception 进入后台登录页
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping(value={"/cms/login","/cms"})
	public String toLogin(){
		return "/cms/login";
	}
	
	/***
	 * 
	 * @Method index
	 * @exception 进入后台首页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("cms/index")
	@isAdmin
	public String index(HttpServletRequest request,  HttpServletResponse response){
		return "cms/index";
	}
	
	/**
	 * 
	 * @Method logout
	 * @exception 退出
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	@RequestMapping("/cmsLogout")
	@isAdmin
	public String logout(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		return "redirect/cms/login.jsp";
	}
	
/********************************* jump end *******************************/
	
/********************************* json start******************************/
	
	/**
	 * 
	 * @Method login
	 * @exception 检查用户名密码
	 * @param work_num 工作号
	 * @param password 密码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("cmsLogin.json")
	@ResponseBody
	public JSON login(String work_num, String password, HttpServletRequest request, HttpServletResponse response){
		JSON json = adminService.login(work_num, password);
		if(json.getErrno() == INFO.Success){
			HttpSession session = request.getSession();
			session.setAttribute("admin", json.getData());
		}
		return json;
	}
	
	/**
	 * 	
	 * @Method modifyPassword
	 * @exception 修改用户名密码
	 * @param current_password 当前密码
	 * @param new_password 新密码
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@RequestMapping("/cmsModifyPwd.json")
	@ResponseBody
	public JSON modifyPassword(String current_password, String new_password, HttpServletRequest request,  HttpServletResponse response){
		HttpSession session =request.getSession();
		Admin user = (Admin) session.getAttribute("admin");
		JSON json = adminService.saveUser(user, current_password, new_password);
		if(json.getErrno() == INFO.Success){
			session.setAttribute("admin", user);
		}
		return json;
	}
	
	/**
	 * 
	 * @Method getAuthByAdmin
	 * @exception 获取后台人员的权限
	 * @param request 请求
	 * @param response 响应
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/cmsGetAuthByAdmin.json")
	@ResponseBody
	public JSON getAuthByAdmin(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session =request.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		JSON json = adminService.getAuthListByAdmin(admin);
		if(json.getErrno() == 0){
			List<Auth> list = (List<Auth>) json.getData();
			for(int i = 0; i<list.size(); i++){
				Auth auth = list.get(i);
				String str = "is"+auth.getRole().getEnglish();
				session.setAttribute(str, true);
			}
		}
		return json;
	}
	
/********************************* json end********************************/
	
}
