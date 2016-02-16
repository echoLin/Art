package cn.edu.xmu.service.cms;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AdminService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version AdminServiceImpl的接口
 */
public interface AdminService {
	
	/**
	 * 
	 * @Method login
	 * @exception 验证登录（用于验证用户是否为后台用户，账户存在，密码正确，已经启用）
	 * @param work_num
	 * @param password
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON login(String work_num, String password);
	
	/**
	 * 
	 * @Method saveUser
	 * @exception 修改密码
	 * @param admin
	 * @param current_password
	 * @param new_password
	 * @return JSON
	 * @author echo
	 * @time 2015年12月18日
	 */
	public JSON saveUser(Admin admin, String current_password, String new_password);

	/**
	 * 
	 * @Title getAuthListByAdmin
	 * @exception 返回个人权限数组
	 * @param admin
	 * @return JSON
	 * @author echo
	 */
	public JSON getAuthListByAdmin(Admin admin);
	
	
}
