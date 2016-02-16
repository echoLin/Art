package cn.edu.xmu.service.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.dao.cms.ArtistDAO;
import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtistServiceImpl.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public class ArtistServiceImpl implements ArtistService{
	
	@Autowired
	private ArtistDAO artistDAO;

	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午14908
	 */
	@Override
	public List<Artist> getArtistList(String status,String page) {
		return artistDAO.getArtistList(status,page);
	}

    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月28日 上午14914
     */
	@Override
	public Artist getArtistById(String id) {
		return artistDAO.getArtistById(id);
	}

    /**
     * 
     * @Override
     * @author letitia
     * @time 2015年12月28日 上午14921
     */
	@Override
	public int getPageNumByStatus(String status) {
		return artistDAO.getPageNumByStatus(status);
	}


	/**
	 * 
	 * @Override
	 * @author letitia
	 * @time 2015年12月28日 上午14927
	 */
	@Override
	public JSON setArtistStatus(String id, String status) {
		Artist artist = artistDAO.getArtistById(id);
		artist.setStatus(Integer.parseInt(status));
		try{
			if(artistDAO.updateArtistStatus(artist)){
				return new JSON(INFO.Success, INFO.ActionSuccess);		
			}		
		} catch (Exception e){		
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Error, INFO.ActionError);
		
	}
	
	

}
