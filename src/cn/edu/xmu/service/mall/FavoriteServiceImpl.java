/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月27日 下午30042
 * @version V1.0
 */
package cn.edu.xmu.service.mall;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.ArtworkDAO;
import cn.edu.xmu.dao.mall.FavoriteDAO;
import cn.edu.xmu.entity.Favorite;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file FavoriteServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现收藏接口
 */
public class FavoriteServiceImpl implements FavoriteService{
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	@Autowired
	private ArtworkDAO artworkDAO;

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30102
	 */
	@Override
	public JSON getFavoriteList(User user, Integer page, Integer type) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		return new JSON(INFO.Success, favoriteDAO.getFavoriteListByUser(user, page, type));
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30102
	 */
	@Override
	public JSON hasFavorite(User user, Object object) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		return new JSON(INFO.Success, favoriteDAO.hasFavorite(user, object));
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30102
	 */
	@Override
	public JSON setFavorite(User user, Object object) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		if(object == null){
			return new JSON(INFO.Error, "收藏对象不存在");
		}
		if(favoriteDAO.hasFavorite(user, object)){
			return new JSON(INFO.Error, "已经收藏");
		}
		try {
			favoriteDAO.saveOrUpdateFavorite(user, object);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, "收藏成功");
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月27日 下午30102
	 */
	@Override
	public JSON deleteFavorite(User user, Object object) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		Favorite favorite = favoriteDAO.getFavoriteByUserAndObject(user, object);
		if(favorite == null){
			return new JSON(INFO.Error, "未收藏");
		}
		try {
			favoriteDAO.deleteFavorite(favorite);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, "成功从收藏夹中移除");
	}

}
