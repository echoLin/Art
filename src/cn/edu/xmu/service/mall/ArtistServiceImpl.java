package cn.edu.xmu.service.mall;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.mall.ArtistDAO;
import cn.edu.xmu.dao.mall.UserDAO;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 提交艺术家申请
 */
public class ArtistServiceImpl implements ArtistService{
	
	@Autowired
	private ArtistDAO artistDAO;
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40118
	 */
	@Override
	public JSON saveArtist(Artist artist,User user) {
		if(user == null){
			return new JSON(INFO.NotLogin, INFO.LoginMALL);
		}
		if(user.getArtist()!=null)
		{
			return new JSON(INFO.Error, INFO.Committed);
		}
		try {
			artist.setUser(user);
			artistDAO.saveOrUpdateArtist(artist);
			user.setArtist(artist);
			userDAO.saveOrUpdateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}

	

}
