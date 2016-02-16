package cn.edu.xmu.dao.mall;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Article;
import cn.edu.xmu.entity.Block;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class ArticleDAOImpl implements ArticleDAO{
	
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
	 * @time 2015年12月19日 上午100208
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleListByBlock(Block block){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleListForMall");
		query.setParameter("block", block);
		query.setParameter("down_time", new Date());
		query.setParameter("status", 4);
		query.setMaxResults(block.getField_count());
		return query.list();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100212
	 */
	@Override
	public Article getArticleById(String id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleByIdAndStatus");
		query.setParameter("id", Long.parseLong(id));
		query.setParameter("status", 4);
		return (Article) query.uniqueResult();
	}

}
