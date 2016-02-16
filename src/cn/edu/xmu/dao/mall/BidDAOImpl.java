/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月31日 上午51636
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Bid;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BidDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class BidDAOImpl implements BidDAO{
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
	 * @Override
	 * @author echo
	 * @time 2015年12月31日 上午51735
	 */
	@Override
	public void saveOrUpdateBid(Bid bid) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(bid);	
	}

}
