package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.User;

public interface ArtistDAO {
	
	public boolean saveOrUpdateArtist(Artist artist) throws Exception;//提交艺术家申请信息
	
	/**
	 * 
	 * @Method getArtistById
	 * @exception TODO
	 * @param artist_id
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public Artist getArtistById(Long artist_id);
	
	/**
	 * 
	 * @Method getArtistByUser
	 * @exception 根据普通用户查找艺术家
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public Artist getArtistByUser(User user);
	
	/**
	 * 
	 * @Method getArtistByIdListForUser
	 * @exception TODO
	 * @param idList
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Artist> getArtistByIdListForUser(List<Long> idList);
	
	/**
	 * 
	 * @Method getArtistByIdForUser
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public Artist getArtistByIdForUser(Long id);
	
	/**
	 * 
	 * @Method getArtistListForUser
	 * @exception TODO
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Artist> getArtistListForUser(Integer page);

}
