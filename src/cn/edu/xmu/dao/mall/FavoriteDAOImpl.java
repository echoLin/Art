/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月27日 下午23346
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.type.LongType;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Favorite;
import cn.edu.xmu.entity.FavoriteArtist;
import cn.edu.xmu.entity.FavoriteArtwork;
import cn.edu.xmu.entity.FavoriteShop;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file FavoriteDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class FavoriteDAOImpl implements FavoriteDAO{
	
	SessionFactory sessionFactory;
	private Integer pageSize = 5;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月27日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午23359
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Favorite> getFavoriteListByUser(User user, Integer page, Integer type) {
		Query query = null;
		switch(type){
		case 1://artist
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtist.getFavoriteListByUser");
			break;
		case 2://shop
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteShop.getFavoriteListByUser");
			break;
		case 3://artwork
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtwork.getFavoriteListByUser");
			break;
		default:
			return null;
		}
		query.setParameter("user", user);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午23359
	 */
	@Override
	public boolean hasFavorite(User user, Object obj) {
		Favorite favorite = this.getFavoriteByUserAndObject(user, obj);
		if(favorite == null){
			return false;
		}
		return true;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30844
	 */
	@Override
	public void saveOrUpdateFavorite(User user, Object object) throws Exception {
		Favorite favorite = null;
		if(object instanceof Artwork){
			favorite = new FavoriteArtwork(user, (Artwork)object);
		}else if(object instanceof Shop){
			favorite = new FavoriteShop(user, (Shop)object);
		}else if(object instanceof Artist){
			favorite = new FavoriteArtist(user, (Artist)object);
		}
		sessionFactory.getCurrentSession().saveOrUpdate(favorite);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30844
	 */
	@Override
	public void deleteFavorite(Favorite favorite) throws Exception {
		sessionFactory.getCurrentSession().delete(favorite);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午41306
	 */
	@Override
	public Favorite getFavoriteById(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Favorite.getFavoriteById");
		query.setParameter("id", id);
		return (Favorite) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午114708
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getHotArtist_idList(Integer page) {
		String sql = "select x.artist_id from (select artist_id, sum(f.user_id) as count from Favorite as f where f.DTYPE='Artist' group by f.artist_id)x order by x.count";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addScalar("artist_id", LongType.INSTANCE);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月28日 上午52547
	 */
	@Override
	public Favorite getFavoriteByUserAndObject(User user, Object obj) {
		Query query = null;
		if(obj instanceof Artwork){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtwork.getFavoriteByUserAndArtwork");
			query.setParameter("artwork", obj);
		}else if(obj instanceof Shop){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteShop.getFavoriteByUserAndShop");
			query.setParameter("shop", obj);
		}else if(obj instanceof Artist){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtist.getFavoriteByUserAndArtist");
			query.setParameter("artist", obj);
		}
		query.setParameter("user", user);
		Favorite favorite = (Favorite) query.uniqueResult();
		return favorite;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月28日 下午23445
	 */
	@Override
	public Integer getFavoriteNum(Object obj) {
		Query query = null;
		if(obj instanceof Artwork){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtwork.getFavoriteListByArtwork");
			query.setParameter("artwork", obj);
		}else if(obj instanceof Shop){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteShop.getFavoriteListByShop");
			query.setParameter("shop", obj);
		}else if(obj instanceof Artist){
			query = sessionFactory.getCurrentSession().getNamedQuery("FavoriteArtist.getFavoriteListByArtist");
			query.setParameter("artist", obj);
		}
		return query.list().size();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午70740
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getHotArtwork_idList(Long category_id, Integer page) {
		String sql = null;
		if(category_id == null || category_id == 0)
			sql = "select x.artwork_id from (select artwork_id, sum(f.user_id) as count from Favorite as f, Artwork as a where f.DTYPE='Artwork' and f.artwork_id = a.id and a.type = 2 group by f.artwork_id)x order by x.count";
		else
			sql = "select x.artwork_id from (select f.artwork_id, sum(f.user_id) as count from Favorite as f, Artwork as a where f.DTYPE='Artwork' and f.artwork_id = a.id and a.type = 2 and a.category_id = "+category_id+" group by f.artwork_id)x order by x.count";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addScalar("artwork_id", LongType.INSTANCE);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午71031
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Long> getHotShop_idList(Long category_id, Integer isCus, Integer page) {
		String sql = null;
		if((category_id == null || category_id == 0) && (isCus == null || isCus == 0)){
			sql = "select x.shop_id from (select shop_id, sum(f.user_id) as count from Favorite as f where f.DTYPE='Shop' group by f.shop_id)x order by x.count";
		}else{
			sql = "select x.shop_id from (select f.shop_id, sum(f.user_id) as count from Favorite as f , Shop as s where f.DTYPE='Shop'";
			if(category_id!=null && category_id != 0)
				sql += " and s.category_id = "+category_id;
			if(isCus != null && isCus !=0)
				sql += " and s.is_customized="+isCus;
			sql += " group by f.shop_id)x order by x.count";
		}
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addScalar("shop_id", LongType.INSTANCE);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}

}
