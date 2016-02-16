package cn.edu.xmu.dao.cms;


import cn.edu.xmu.entity.Admin;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AdminDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface AdminDAO {
	/**
	 * 
	 * @Method login
	 * @exception 检查登录
	 * @param work_num
	 * @param password
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public Admin login(String work_num, String password) throws Exception;
	
	/**
	 * 
	 * @Method modifyPassword
	 * @exception 修改密码
	 * @param admin
	 * @param current_password
	 * @param new_password
	 * @return
	 * @author echo
	 * @time 2015年12月18日
	 */
	public Admin modifyPassword(Admin admin, String current_password, String new_password) throws Exception;
}
