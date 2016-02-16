package cn.edu.xmu.dao.cms;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Artist;

public class ArtistDAOImpl implements ArtistDAO{
	
	private SessionFactory sessionFactory;
	int pageSize = 5;

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
	 * @time 2015年12月28日 上午12453
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artist> getArtistList(String status,String page) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistByStatus");
		query.setParameter("status",Integer.parseInt(status));
		query.setFirstResult((Integer.parseInt(page)-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
    
	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午12500
	 */
	@Override
	public Artist getArtistById(String id) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistById");
		query.setParameter("id",Long.parseLong(id));
		return (Artist)query.uniqueResult();
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午12506
	 */
	@Override
	public int getPageNumByStatus(String status) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistByStatus");
		query.setParameter("status", Integer.parseInt(status));
		int num = query.list().size()/pageSize;
		if(query.list().size()%pageSize != 0)
			num++;
		return num;
	}

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午12514
	 */
	@Override
	public boolean updateArtistStatus(Artist artist) {
		sessionFactory.getCurrentSession().update(artist);
		return true;
	}
	

}
