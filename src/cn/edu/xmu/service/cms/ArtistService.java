package cn.edu.xmu.service.cms;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.JSON;
/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public interface ArtistService {
	
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
	public List<Artist> getArtistList(String status,String page);//获取艺术家列表
	
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
	public Artist getArtistById(String id);//通过id获取单个艺术家
	
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
	public int getPageNumByStatus(String status);//获取某状态的页码
	
	/**
	 * 
	 * 
	 * @Method setArtistStatus
	 * @exception TODO
	 * @param id
	 * @param status
	 * @return
	 * @author letitia
	 * @time 2015年12月28日
	 */
	public JSON setArtistStatus(String id,String status);//修改艺术家状态（审核是否通过）

}
