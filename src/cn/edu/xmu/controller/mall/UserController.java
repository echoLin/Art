package cn.edu.xmu.controller.mall;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.edu.xmu.controller.AOP.isUser;
import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.ReturnInfo;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.service.mall.UserService;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file UserController.java
 * @package cn.edu.xmu.controller.mall
 * @project Art
 * @version 用户控制器
 */
@Controller
public class UserController {
	@Resource(name="userService_mall")
	private UserService userService;
	
	/** 
	 * @Method user
	 * @exception 进入个人主页
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/jsp/user/user")
	@isUser
	public String user(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/mall/jsp/user/user";
	}
	
	/** 
	 * @Method jump_login
	 * @exception 进入登录页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	@RequestMapping("/mall/login")
	public String jump_login(){
		return "/mall/login";
	}
	
	/** 
	 * @Method jump_register
	 * @exception 进入注册页面
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	@RequestMapping("/mall/jsp/user/register")
	public String jump_register(){
		return "/mall/jsp/user/register";
	}
	/** 
	 * @Method jump_username
	 * @exception 进入修改用户名页面
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/jsp/user/username")
	@isUser
	public String jump_username(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/mall/jsp/user/username";
	}
	
	/** 
	 * @Method jump_telephone
	 * @exception 进入修改手机号页面
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/jsp/user/telephone")
	@isUser
	public String jump_telephone(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/mall/jsp/user/telephone";
	}
	
	/** 
	 * @Method jump_password
	 * @exception 进入修改密码页面
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/jsp/user/password")
	@isUser
	public String jump_password(HttpServletRequest request,  HttpServletResponse response){
		
		return "/mall/jsp/user/password";
	}
	
	/** 
	 * @Method logout
	 * @exception 退出登录
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月23日
	 */
	@RequestMapping("/mall/logout")
	@isUser
	public String logout(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect/mall/index";
	}
	
	/** 
	 * @Method toAvatar
	 * @exception 进入上传头像页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author Qing
	 * @time 2015年12月23日
	 */
	@RequestMapping("/mall/jsp/user/avatar")
	@isUser
	public String toAvatar(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		request.setAttribute("user", session.getAttribute("user"));
		return "/mall/jsp/user/avatar";
	}
	
	/**
	 * 
	 * 
	 * @Method toAddress
	 * @exception 收货地址
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	@RequestMapping("/mall/jsp/user/address")
	@isUser
	public String toAddress(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Address> list = userService.getAddressListByUser(user);
		request.setAttribute("user", user);
		request.setAttribute("list", list);
		return "/mall/jsp/user/address";
	}
	
	/**
	 * 
	 * 
	 * @Method toAddressInfo
	 * @exception 进入收货信息页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月29日
	 */
	@RequestMapping("/mall/jsp/user/addressInfo")
	@isUser
	public String toAddressInfo(Integer tag,String id,HttpServletRequest request,  HttpServletResponse response){		
		if(tag == 1){
			Address address = userService.getAddressById(Long.parseLong(id));
			request.setAttribute("address", address);
		}			
		return "/mall/jsp/user/addressInfo";
	}

	/**
	 * 
	 * 
	 * @Method toMoney
	 * @exception 进入收账户余额界面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */ 
	@RequestMapping("/mall/jsp/user/money")
	@isUser
	public String toMoney(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/mall/jsp/user/money";
	}
	
	/**
	 * 
	 * 
	 * @Method toRecharge
	 * @exception 进入充值页面
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */ 
	@RequestMapping("/mall/jsp/user/recharge")
	@isUser
	public String toRecharge(HttpServletRequest request,  HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		return "/mall/jsp/user/recharge";
	}

/*********************************JSON******************************************/	
	
	/** 
	 * @Method login
	 * @exception 通过用户名或手机号登录
	 * @param nameORtel 用户名或手机号码
	 * @param password 密码
	 * @param request 请求
	 * @param response 响应
	 * @return 
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/login.json")
	@ResponseBody
	public ReturnInfo login(String nameORtel,String password,HttpServletRequest request, HttpServletResponse response){
		ReturnInfo err=new ReturnInfo(0,"登陆成功");
		User user=userService.login(nameORtel, password);
		if(user==null){
			err.settype(1);
			err.setinfo("用户名或密码错误");
			return err;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return err;
	}
	

	
	/** 
	 * @Method register
	 * @exception 注册
	 * @param user 用户
	 * @return
	 * @author Qing
	 * @time 2015年12月20日
	 */
	@RequestMapping("/mall/register.json")
	@ResponseBody
	public ReturnInfo register(User user){
		ReturnInfo err=new ReturnInfo();
		if(userService.getUserByUsername(user.getUsername())!=null)
		{
			err.settype(1);
			err.setinfo("该用户名已注册");		
		}
		else if(userService.getUserByTelephone(user.getTelephone())!=null)
		{
			err.settype(2);
			err.setinfo("该手机号已注册");
		}
		else{
			if(!user.check_username(user.getUsername())||!user.check_tel(user.getTelephone())||!user.check_psd(user.getPassword()))
				return new ReturnInfo(3,"注册信息不符合规范");
			user.setRegister_time(new Date());
			userService.addUser(user);
			err.settype(0);
			err.setinfo("注册成功");
		}
	
		//System.out.println(err.getinfo());
		return err;
	}
	
	/** 
	 * @Method modify_username
	 * @exception 修改用户名
	 * @param new_name 新的用户名
	 * @param request 请求
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	@RequestMapping("/mall/modify_username.json")
	@ResponseBody
	public JSON modify_username(String new_name,HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(!user.check_username(new_name))
			return new JSON(1,"新的用户名不符合规范");
		if(userService.getUserByUsername(new_name)!=null){
			return new JSON(2,"用户名已存在");
		}
		else{
			user.setUsername(new_name);
			return userService.saveOrUpdateUser(user);
		}
	}
	
	/** 
	 * @Method modify_tel
	 * @exception 修改手机号
	 * @param new_tel 新的手机号
	 * @param request 请求
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	@RequestMapping("/mall/modify_tel.json")
	@ResponseBody
	public JSON modify_tel(String new_tel,HttpServletRequest request){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		if(!user.check_tel(user.getTelephone()))
			return new JSON(1,"新的手机号不正确");
		if(userService.getUserByUsername(new_tel)!=null){
			return new JSON(2,"新的手机号已存在");
		}
		else{
			user.setTelephone(new_tel);
			return userService.saveOrUpdateUser(user);
		}
	}
	
	/** 
	 * @Method modify_psd
	 * @exception 修改密码
	 * @param old_psd 旧密码
	 * @param new_psd 新密码
	 * @param request 请求
	 * @return
	 * @author Qing
	 * @time 2015年12月21日
	 */
	@RequestMapping("/mall/modify_psd.json")
	@ResponseBody
	public ReturnInfo modify_psd(String old_psd,String new_psd,HttpServletRequest request){
		HttpSession session=request.getSession();
		ReturnInfo info=new ReturnInfo(0,"修改成功");
		User user=(User) session.getAttribute("user");
		if(user==null)
			jump_login();
		if(!user.getPassword().equals(old_psd)){
			info.settype(1);
			info.setinfo("原密码错误");
			return info;
		}
		if(!user.check_psd(user.getPassword()))
			return new ReturnInfo(2,"新的密码不符合规范");
		if(userService.modify_psd(user,new_psd)==null){
			info.settype(3);
			info.setinfo("修改失败");
		}
		return info;
	}
	
	/**
	 * 
	 * @Method saveAvator
	 * @exception 修改头像
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	@RequestMapping("/mallSaveAvatar.json")
	@ResponseBody
	public JSON saveAvator(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request; 
		MultipartFile file = multipartRequest.getFile("avatar"); 
        //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹   
        return userService.saveAvatar(file, user);
	}
	
	/**
	 * 
	 * 
	 * @Method saveAddress
	 * @exception 添加一个新的地址
	 * @param address 新地址
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	@RequestMapping("/mall/Address.json")
	@ResponseBody
	public JSON saveAddress(Address address, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");		
		return userService.saveOrUpdateAddress(user, address);
	}
	
	/**
	 * 
	 * @Method deleteAddress
	 * @exception 删除地址
	 * @param id 地址ID
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	@RequestMapping("/mall/deleteAddress.json")
	@ResponseBody
	public JSON deleteAddress(String id, HttpServletRequest request, HttpServletResponse response){
		return userService.deleteAddress(Long.parseLong(id));
	}

	/**
	 * 
	 * 
	 * @Method modifyAddressStatus
	 * @exception 修改默认地址
	 * @param addressId 定制ID
	 * @param is_default 是否默认
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author letitia
	 * @time 2015年12月30日
	 */
	@RequestMapping("/mall/modifyAddressStatus.json")
	@ResponseBody
	public JSON modifyAddressStatus(String id, String is_default,HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return userService.modifyAddressStatus(user,Long.parseLong(id),Integer.parseInt(is_default));	
	}
	
	/**
	 * 
	 * @Method rechargeMoney
	 * @exception 充值
	 * @param recharge 充值金额
	 * @param request 请求
	 * @param response 响应
	 * @return
	 * @author echo
	 * @time 2016年1月18日
	 */
	@RequestMapping("/mall/recharge.json")
	@ResponseBody
	public JSON rechargeMoney(String recharge,HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		return userService.rechargeMoney(user,recharge);	

	}
}
