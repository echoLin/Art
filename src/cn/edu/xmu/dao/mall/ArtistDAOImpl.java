package cn.edu.xmu.dao.mall;

import java.util.List;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.User;

public class ArtistDAOImpl implements ArtistDAO{
	
	private SessionFactory sessionFactory;
	private Integer pageSize = 5;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月27日 下午104033
     */
	@Override
	public boolean saveOrUpdateArtist(Artist artist) throws Exception {
		artist.setApply_time(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(artist);
		return true;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月26日 下午90213
	 */
	@Override
	public Artist getArtistById(Long artist_id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistById");
		query.setParameter("id", artist_id);
		return (Artist) query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午24459
	 */
	@Override
	public Artist getArtistByUser(User user) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistByUser");
		query.setParameter("user", user);
		return (Artist)query.uniqueResult();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月28日 上午125248
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artist> getArtistByIdListForUser(List<Long> idList) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistListByIdListForUser");
		query.setParameterList("idList", idList);
		return query.list();
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午43032
	 */
	@Override
	public Artist getArtistByIdForUser(Long id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistByIdForUser");
		query.setParameter("id", id);
		return (Artist) query.uniqueResult();
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月29日 下午54520
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Artist> getArtistListForUser(Integer page) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Artist.getArtistListForUser");
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
	}
	
}
