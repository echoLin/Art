package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Auth;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AuthDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface AuthDAO {
	
	/**
	 * 
	 * @Method getAuthListByAdmin
	 * @exception TODO
	 * @param admin
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Auth> getAuthListByAdmin(Admin admin);
	
}
