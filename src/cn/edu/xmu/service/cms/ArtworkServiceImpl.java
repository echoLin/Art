/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.cms
 * @exception TODO
 * @author echo
 * @date 2015年12月22日 下午90131
 * @version V1.0
 */
package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.cms.ArtworkDAO;
import cn.edu.xmu.dao.mall.LotDAO;
import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public class ArtworkServiceImpl implements ArtworkService{
	@Autowired
	private ArtworkDAO artworkDAO;

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午90147
	 */
	@Override
	public List<Artwork> getList(String type, String is_passed, String page) {
		return artworkDAO.getList(type, is_passed, page);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午90147
	 */
	@Override
	public JSON setArtworkPass(String id, String is_passed, Admin admin) {
		if(admin == null){
			return new JSON(INFO.NotLogin, INFO.LoginCMS);
		}
		Artwork artwork = artworkDAO.getArtworkById(id);
		artwork.setIs_passed(Integer.parseInt(is_passed));
		try {
			artworkDAO.saveOrUpdateArtwork(artwork);
		} catch (Exception e) {
			return new JSON(INFO.Error, INFO.ActionError);
			//e.printStackTrace();
		}
		return new JSON(INFO.Success, INFO.ActionSuccess);
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月22日 下午91402
	 */
	@Override
	public Artwork getArtworkById(String id) {
		return artworkDAO.getArtworkById(id);
	}


	
}
