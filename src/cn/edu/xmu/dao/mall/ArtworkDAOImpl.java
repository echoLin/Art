package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class ArtworkDAOImpl implements ArtworkDAO{
	
	SessionFactory sessionFactory;
	Integer pageSize = 5;

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
	 * @time 2015年12月27日 上午102302
	 */
	@Override
	public Artwork saveOrUpdateArtwork(Artwork artwork) throws Exception {
		artwork.setIs_passed(1);
		sessionFactory.getCurrentSession().saveOrUpdate(artwork);
		return artwork;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午41028
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkByArtistForUser(Artist artist, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByArtistForUser");
		query.setParameter("artist", artist);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午41028
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkListByTypeForUser(Integer type, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByTypeForUser");
		query.setParameter("type", type);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午41028
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkListByCagetoryAndTypeForUser(Long category_id,
			Integer type, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByCategoryAndTypeForUser");
		Category category = new Category();
		category.setId(category_id);
		query.setParameter("category", category);
		query.setParameter("type", type);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午41028
	 */
	@Override
	public Artwork getArtworkByIdForUser(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkByIdForUser");
		query.setParameter("id", id);
		return (Artwork) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午71220
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkListByIdGroupForUser(List<Long> idList) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByIdListForUser");
		query.setParameterList("idList", idList);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getArtworkListByShopForUser(Long id, Integer type,
			Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByShopForUser");
		Shop shop = new Shop();
		shop.setId(id);
		query.setParameter("shop", shop);
		query.setParameter("type", type);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}


	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkListByShopAndTypeForArtist(Shop shop, Integer type) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByShopAndTypeForArtist");
		query.setParameter("shop", shop);
		query.setParameter("type", type);
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artwork> getArtworkListByShopForArtist(Shop shop) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkListByShopForArtist");
		query.setParameter("shop", shop);
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public boolean saveOrUpdateArtworkForArtist(Artwork artwork) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(artwork);
		return true;
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public Artwork getArtworkByIdForArtist(Long artwork_id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Artwork.getArtworkByIdForArtist");
		query.setParameter("id", artwork_id);
		return (Artwork) query.uniqueResult();
	}

}
