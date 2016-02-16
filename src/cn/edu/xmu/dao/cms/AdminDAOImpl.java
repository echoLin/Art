package cn.edu.xmu.dao.cms;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Admin;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AdminDAOImpl.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class AdminDAOImpl implements AdminDAO {
	
	private SessionFactory sessionFactory;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月19日
	 */
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94454
	 */
	@Override
	public Admin login(String work_num, String password){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Admin.getAdminByWorkNum");
		query.setString("work_num", work_num);
		query.setString("password", password);
		return (Admin)query.uniqueResult();
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94451
	 */
	@Override
	public Admin modifyPassword(Admin admin, String current_password, String new_password){
		if(!admin.equalsToPassword(current_password)){
			return null;
		}
		admin.setPassword(new_password);
		sessionFactory.getCurrentSession().update(admin);
		return admin;
	}
}
