package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Artist;

/**
 * 
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface ArtistDAO {
	
	/**
	 * 
	 * 
	 * @Method getArtistList
	 * @exception TODO
	 * @param status
	 * @param page
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public List<Artist> getArtistList(String status,String page);//根据状态获取数据库中所有艺术家的列表
	
	/**
	 * 
	 * 
	 * @Method getArtistById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public Artist getArtistById(String id);//通过id获取单个艺术家的信息
	
	/**
	 * 
	 * 
	 * @Method getPageNumByStatus
	 * @exception TODO
	 * @param status
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public int getPageNumByStatus(String status);//获取页码
	
	/**
	 * 
	 * 
	 * @Method updateArtistStatus
	 * @exception TODO
	 * @param artist
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public boolean updateArtistStatus(Artist artist);//更新艺术家审核状态
	

}
