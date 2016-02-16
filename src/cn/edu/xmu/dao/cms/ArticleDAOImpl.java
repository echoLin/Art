package cn.edu.xmu.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Article;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArticleDAOImpl.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class ArticleDAOImpl implements ArticleDAO {
	
	private int pageSize = 5;
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
	 * @time 2015年12月19日 上午94645
	 */
	@Override
	public boolean saveOrUpdateArticle(Article article) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(article);
		return true;
	}
	
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94649
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleListByEditorAndStatus(Admin  editor,
			String status, String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleListByEditorAndStatus");
		query.setParameter("status", Integer.parseInt(status));
		query.setParameter("editor", editor);
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94652
	 */
	@Override
	public int getPageNumByEditorAndStatus(Admin editor, String status) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleListByEditorAndStatus");
		query.setParameter("status", Integer.parseInt(status));
		query.setParameter("editor", editor);
		int num = query.list().size()/pageSize;
		if(query.list().size()%pageSize != 0){
			num++;
		}
		return num;
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94656
	 */
	@Override
	public boolean deleteArticle(Article article) throws Exception{
		sessionFactory.getCurrentSession().delete(article);
		return true;
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94700
	 */
	@Override
	public Article getArticleById(String id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleById");
		query.setParameter("id", Long.parseLong(id));
		return (Article) query.uniqueResult();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94703
	 */
	@Override
	public int getPageNumByStatus(String status) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleListByStatus");
		query.setParameter("status", Integer.parseInt(status));
		int num = query.list().size()/pageSize;
		if(query.list().size()%pageSize != 0){
			num++;
		}
		return num;
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午94707
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticleListStatus(String status, String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleListByStatus");
		query.setParameter("status", Integer.parseInt(status));
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
}
