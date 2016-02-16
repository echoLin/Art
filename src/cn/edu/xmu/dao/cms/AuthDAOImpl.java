package cn.edu.xmu.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Auth;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file AuthDAOImpl.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class AuthDAOImpl implements AuthDAO {
	
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
	 * @time 2015年12月19日 上午94806
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Auth> getAuthListByAdmin(Admin admin) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Auth.getAuthListByAdmin");
		query.setParameter("admin", admin);
		return query.list();
	}

}
