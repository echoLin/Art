package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Category;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file CategoryDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class CategoryDAOImpl implements CategoryDAO{

	SessionFactory sessionFactory;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月19日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100355
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Category.getCategoryList");
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月24日
	 */
	@Override
	public Category getCategoryById(Long category_id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Category.getCategoryById");
		query.setParameter("id", category_id);
		return (Category) query.uniqueResult();
	}

}
