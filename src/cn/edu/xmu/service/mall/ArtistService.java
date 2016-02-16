package cn.edu.xmu.service.mall;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.User;

/**
 * 
 * @Copyright Copyright (c) 2015 letitia
 * All rights reserved
 *
 * @file ArtistService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 提交艺术家申请
 */
public interface ArtistService {
	
	/**
	 * 
	 * @Method saveArtist
	 * @exception 提交艺术家申请信息
	 * @param artist
	 * @param user
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public JSON saveArtist(Artist artist,User user);

}
