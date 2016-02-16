/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.cms
 * @exception TODO
 * @author echo
 * @date 2015年12月22日 下午85038
 * @version V1.0
 */
package cn.edu.xmu.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Lot;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkDAOImpl.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public class ArtworkDAOImpl implements ArtworkDAO{
	private SessionFactory sessionFactory;
	private static Integer pageSize = 10;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月22日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午85052
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getList(String type, String is_passed, String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByTypeAndIsPassed");
		query.setParameter("type", Integer.parseInt(type));
		query.setParameter("is_passed", Integer.parseInt(is_passed));
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午85705
	 */
	@Override
	public boolean saveOrUpdateArtwork(Artwork artwork) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(artwork);
		return true;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午90321
	 */
	@Override
	public Artwork getArtworkById(String id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Article.getArticleById");
		query.setParameter("id", Long.parseLong(id));
		return (Artwork) query.uniqueResult();
	}


}
