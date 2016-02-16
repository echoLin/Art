/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月24日 下午95621
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file LotDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class LotDAOImpl implements LotDAO{
	
	SessionFactory sessionFactory;
	Integer pageSize = 5;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月24日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午94552
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> getLotListForUser(Long category_id, Integer time,
			Integer page) {
		Query query = null;
		
		if(category_id == null || category_id == 0){//没有类别限制
			if(time == 1){//当前正在
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByNowForUser");
				query.setParameter("end_time", new Date());
				query.setParameter("start_time", new Date());
			}else if(time == 2){//未来
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByFutureForUser");
				query.setParameter("start_time", new Date());
			}else{
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListForUser");
				query.setParameter("end_time", new Date());
			}
		}else{//有类别限制
			Category category = new Category();
			category.setId(category_id);
			if(time == 1){
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByCategoryAndNowForUser");
				query.setParameter("end_time", new Date());
				query.setParameter("start_time", new Date());
				query.setParameter("category", category);
			}else if(time == 2){
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByCategoryAndFutureForUser");
				query.setParameter("start_time", new Date());
				query.setParameter("category", category);
			}else{
				query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByCategoryForUser");
				query.setParameter("end_time", new Date());
				query.setParameter("category", category);
			}
		}
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 上午55426
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getLotListByShopForUser(Long shop_id, Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByShopForUser");
		query.setParameter("end_time", new Date());
		Shop shop = new Shop();
		shop.setId(shop_id);
		query.setParameter("shop", shop);
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
	public List<Lot> getLotListByShopForArtist(Shop shop) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByShopForArtist");
		query.setParameter("shop", shop);
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Lot> getLotListByShopAndIsPassedForArtist(Shop shop, Integer is_passed) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotListByShopAndIsPassedForArtist");
		query.setParameter("shop", shop);
		query.setParameter("is_passed", is_passed);
		return query.list();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月29日
	 */
	@Override
	public boolean saveOrUpdateLot(Lot lot) throws Exception{
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(lot);
		return true;
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public Lot getLotByIdForArtist(Long lot_id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotByIdForArtist");
		query.setParameter("id", lot_id);
		return (Lot) query.uniqueResult();
	}

	/**
	 * @Override
	 * @authorQing
	 * @time2015年12月30日
	 */
	@Override
	public boolean deleteLot(Lot lot) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(lot);
		return true;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 上午64230
	 */
	@Override
	public Lot getLotByIdForUser(Long id) {
		Query query=sessionFactory.getCurrentSession().getNamedQuery("Lot.getLotByIdForUser");
		query.setParameter("id", id);
		return (Lot) query.uniqueResult();
	}

}
