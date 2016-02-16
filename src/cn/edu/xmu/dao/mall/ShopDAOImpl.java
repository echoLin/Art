package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Query;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ShopDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class ShopDAOImpl implements ShopDAO{
	
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
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100428
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListForArtist(String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListForArtist");
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100431
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByCategoryForArtist(String category_id, String page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByCategoryForArtist");
		Category category = new Category();
		category.setId(Long.parseLong(category_id));
		query.setParameter("category", category);
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100434
	 */
	@Override
	public Shop getShopByIdForArtist(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopByIdForArtist");
		query.setParameter("id", id);
		return (Shop) query.uniqueResult();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月19日 上午100442
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByArtistForArtist(Artist artist, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByArtistForArtist");
		query.setParameter("artist", artist);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月24日
	 */
	@Override
	public boolean saveOrUpdateShop(Shop shop) {
		shop.setIs_passed(1);
		sessionFactory.getCurrentSession().saveOrUpdate(shop);
		return true;
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月24日
	 */
	@Override
	public Shop getShopByNameForArtist(String name) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopByNameForArtist");
		query.setParameter("name", name);
		return (Shop) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月26日 下午84355
	 */
	@Override
	public Shop getShopByArtistAndShop_idForArtist(Artist artist, Long shop_id) {
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopByArtistAndShop_idForArtist");
		query.setParameter("id", shop_id);
		query.setParameter("artist", artist);
		return (Shop) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午15843
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByArtistAndIsPassed(Artist artist,
			Integer is_passed, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByArtistAndIsPassed");
		query.setParameter("artist", artist);
		query.setParameter("is_passed", is_passed);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public Shop getShopById(Long id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopById");
		query.setParameter("id", id);
		return (Shop) query.uniqueResult();
	}
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午45219
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByArtistForUser(Artist artist, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByArtistForUser");
		query.setParameter("artist", artist);
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
	public List<Shop> getShopListByArtist(Artist artist, Integer page) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByArtist");
		query.setParameter("artist", artist);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午45219
	 */
	@Override
	public Shop getShopByIdForUser(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopByIdForUser");
		query.setParameter("id", id);
		return (Shop) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午83153
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByIdListForUser(List<Long> idList) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getShopListByIdListForUser");
		query.setParameterList("idList", idList);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午83630
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopListByCategoryAndIsCusForUser(Long category_id,
			Integer isCus, Integer page) {
		Query query = null;
		if((category_id == null || category_id == 0)&&(isCus != 1 && isCus != -1)){
			query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListForUser");
		}else if((category_id != null && category_id != 0)&&(isCus != 1 && isCus != -1)){
			query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShoListByCategoryForUser");
			Category category = new Category();
			category.setId(category_id);
			query.setParameter("category", category);
		}else if((category_id == null || category_id == 0)&&(isCus == 1 || isCus == -1)){
			query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByIsCusForUser");
			query.setParameter("is_customized", isCus);
		}else{
			query = sessionFactory.getCurrentSession().getNamedQuery("Shop.getShopListByCategoryAndIsCusForUser");
			Category category = new Category();
			category.setId(category_id);
			query.setParameter("category", category);
			query.setParameter("is_customized", isCus);
		}
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
