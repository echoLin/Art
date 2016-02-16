package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.cms.AdminDAO;
import cn.edu.xmu.dao.cms.AuthDAO;
import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Auth;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AdminServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private AuthDAO authDAO;
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 上午103434
	 */
	@Override
	public JSON login(String work_num, String password) {
		Admin admin = null;
		try {
			admin = adminDAO.login(work_num, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(admin == null){
			return new JSON(INFO.Error, INFO.LoginError);
		}
		return new JSON(INFO.Success, admin);
	}
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 上午103419
	 */
	@Override
	public JSON saveUser(Admin admin, String current_password, String new_password){
		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		try {
			admin = adminDAO.modifyPassword(admin, current_password, new_password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(admin == null){
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, admin);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月18日 上午103423
	 */
	@Override
	public JSON getAuthListByAdmin(Admin admin){
		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		List<Auth> list = authDAO.getAuthListByAdmin(admin);
		return new JSON(INFO.Success, list);
	}
	
}
