package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BlockDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class BlockDAOImpl implements BlockDAO{
	
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
	 * @time 2015年12月19日 上午100329
	 */
	@Override
	public Block getBlockById(Integer id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Block.getBlockById");
		query.setParameter("id", id);
		return (Block) query.uniqueResult();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100332
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Block> getBlockList() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Block.getBlockList");
		return query.list();
	}

}
