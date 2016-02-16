package cn.edu.xmu.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Lot;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file LotDAOImpl.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class LotDAOImpl implements LotDAO{
	
	private SessionFactory sessionFactory;
	private static Integer pageSize = 10;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午125755
	 */
	@Override
	public List<Lot> getLotByIsPasssed(String is_passed, String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByIsPassed");
		query.setParameter("is_passed", Integer.parseInt(is_passed));
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午11721
	 */
	@Override
	public Lot getLotById(String id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotById");
		query.setParameter("id", Long.parseLong(id));
		return (Lot) query.uniqueResult();
	}
    
	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午12248
	 */
	@Override
	public int getPageNumByIsPassed(String is_passed) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByIsPassed");
		query.setParameter("is_passed", Integer.parseInt(is_passed));
		int num = query.list().size()/pageSize;
		if(query.list().size()%pageSize != 0)
			num++;
		return num;
	}

	@Override
	public boolean updateLotIsPassed(Lot lot) {
		sessionFactory.getCurrentSession().update(lot);
		return true;
	}

}
