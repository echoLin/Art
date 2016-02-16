/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.cms
 * @exception TODO
 * @author echo
 * @date 2015年12月22日 下午84616
 * @version V1.0
 */
package cn.edu.xmu.dao.cms;

import java.util.List;

import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Lot;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkDAO.java
 * @package cn.edu.xmu.dao.cms
 * @project Art
 * @exception TODO
 */
public interface ArtworkDAO {
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
	 * @Method saveOrUpdateArtwork
	 * @exception TODO
	 * @param artwork
	 * @return
	 * @author echo
	 * @time 2015年12月22日
	 */
	public boolean saveOrUpdateArtwork(Artwork artwork) throws Exception;
	
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
