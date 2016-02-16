package cn.edu.xmu.dao.cms;

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
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class CategoryDAOImpl implements CategoryDAO{
	
	SessionFactory sessionFactory;
	private int pageSize = 10;

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
	 * @time 2015年12月19日 上午94924
	 */
	@Override
	public boolean saveOrUpdateCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94928
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategoryList(String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Category.getCategoryList");
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94931
	 */
	@Override
	public Integer getPageNumOfCategory() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Category.getCategoryList");
		int num = query.list().size()/pageSize;
		if(query.list().size()%pageSize != 0){
			num++;
		}
		return num;
	}

	/**
	 * 
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月30日 下午93722
	 */
	@Override
	public boolean addCategory(String category) {
		Category obj = new Category();
		obj.setName(category);
		sessionFactory.getCurrentSession().save(obj);
		return true;
	}

}
