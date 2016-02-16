/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月27日 下午30010
 * @version V1.0
 */
package cn.edu.xmu.service.mall;

import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file FavoriteService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 收藏夹接口
 */
public interface FavoriteService {
	/**
	 * 
	 * @Method getFavoriteList
	 * @exception TODO
	 * @param user
	 * @param page
	 * @param type
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public JSON getFavoriteList(User user, Integer page, Integer type);
	
	/**
	 * 
	 * @Method hasFavorite
	 * @exception TODO
	 * @param user
	 * @param object
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public JSON hasFavorite(User user, Object object);
	
	/**
	 * 
	 * @Method setFavorite
	 * @exception TODO
	 * @param user
	 * @param object
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public JSON setFavorite(User user, Object object);
	
	/**
	 * 
	 * @Method deleteFavorite
	 * @exception TODO
	 * @param user
	 * @param object
	 * @return
	 * @author echo
	 * @time 2015年12月28日
	 */
	public JSON deleteFavorite(User user, Object object);
}
