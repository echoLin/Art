/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月27日 下午23006
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Favorite;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file FavoriteDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface FavoriteDAO {
	/**
	 * 
	 * @Method getFavoriteListByUser
	 * @exception 获取用户的收藏列表
	 * @param user
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public List<Favorite> getFavoriteListByUser(User user, Integer page, Integer type);
	
	/**
	 * 
	 * @Method getFavoriteByUserAndObject
	 * @exception TODO
	 * @param user
	 * @param object
	 * @return
	 * @author echo
	 * @time 2015年12月28日
	 */
	public Favorite getFavoriteByUserAndObject(User user, Object object);
	
	/**
	 * 
	 * @Method hasFavorite
	 * @exception 用户是否收藏过该作品
	 * @param user
	 * @param object
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public boolean hasFavorite(User user, Object object);
	
	/**
	 * 
	 * @Method saveOrUpdateFavorite
	 * @exception TODO
	 * @param user
	 * @param obj
	 * @throws Exception
	 * @author echo
	 * @time 2015年12月27日
	 */
	public void saveOrUpdateFavorite(User user, Object obj) throws Exception;
	
	/**
	 * 
	 * @Method deleteFavorite
	 * @exception 删除收藏
	 * @param favorite
	 * @throws Excption
	 * @author echo
	 * @time 2015年12月27日
	 */
	public void deleteFavorite(Favorite favorite) throws Exception;
	
	/**
	 * 
	 * @Method getFavoriteById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public Favorite getFavoriteById(Long id);
	
	/**
	 * 
	 * @Method getHotArtist_idList
	 * @exception TODO
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Long> getHotArtist_idList(Integer page);
	
	/**
	 * 
	 * @Method getHotArtwork_idList
	 * @exception TODO
	 * @param category_id
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Long> getHotArtwork_idList(Long category_id, Integer page);
	
	/**
	 * 
	 * @Method getHotShop_idList
	 * @exception TODO
	 * @param category_id
	 * @param isCus
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Long> getHotShop_idList(Long category_id, Integer isCus, Integer page);
	
	/**
	 * 
	 * @Method getFavoriteNum
	 * @exception 获取该对象的收藏人数
	 * @param obj
	 * @return
	 * @author echo
	 * @time 2015年12月28日
	 */
	public Integer getFavoriteNum(Object obj);
	
}
