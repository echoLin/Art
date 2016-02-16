/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.cms
 * @exception TODO
 * @author echo
 * @date 2015年12月22日 下午85809
 * @version V1.0
 */
package cn.edu.xmu.service.cms;

import java.util.List;

import cn.edu.xmu.entity.Admin;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkService.java
 * @package cn.edu.xmu.service.cms
 * @project Art
 * @version TODO
 */
public interface ArtworkService {
	/**
	 * 
	 * @Method getList
	 * @exception TODO
	 * @param type
	 * @param is_passed
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月22日
	 */
	public List<Artwork> getList(String type, String is_passed, String page);
	
	/**
	 * 
	 * @Method setArtworkPass
	 * @exception TODO
	 * @param id
	 * @param is_passed
	 * @param admin
	 * @return
	 * @author echo
	 * @time 2015年12月22日
	 */
	public JSON setArtworkPass(String id, String is_passed, Admin admin);
	
	/**
	 * 
	 * @Method getArtworkById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月22日
	 */
	public Artwork getArtworkById(String id);

}
