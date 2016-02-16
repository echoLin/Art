package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtworkDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface ArtworkDAO {
	
	/**
	 * 
	 * @Method getArtworkByArtistForUser
	 * @exception TODO
	 * @param artist
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public List<Artwork> getArtworkByArtistForUser(Artist artist, Integer page);
	
	/**
	 * 
	 * @Method getArtworkListByTypeForUser
	 * @exception TODO
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public List<Artwork> getArtworkListByTypeForUser(Integer type, Integer page);
	
	/**
	 * 
	 * @Method getArtworkListByCagetoryAndTypeForUser
	 * @exception TODO
	 * @param category_id
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public List<Artwork> getArtworkListByCagetoryAndTypeForUser(Long category_id, Integer type, Integer page);
	
	/**
	 * 
	 * @Method getArtworkByIdForUser
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public Artwork getArtworkByIdForUser(Long id);
	
	/**
	 * 
	 * @Method getArtworkListByIdGroupForUser
	 * @exception TODO
	 * @param idList
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public List<Artwork> getArtworkListByIdGroupForUser(List<Long> idList);
	
	/**
	 * 
	 * @Method getArtworkListByShopForUser
	 * @exception TODO
	 * @param id
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public List<Object> getArtworkListByShopForUser(Long id, Integer type, Integer page);
	
	/**
	 * 
	 * @Method saveOrUpdateArtwork
	 * @exception TODO
	 * @param artwork
	 * @throws Exception
	 * @author echo
	 * @return 
	 * @time 2015年12月27日
	 */
	public Artwork saveOrUpdateArtwork(Artwork artwork) throws Exception;


	/** 
	 * @Method getArtworkListByShopAndTypeForArtist
	 * @exception TODO
	 * @param shop
	 * @param type
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public List<Artwork> getArtworkListByShopAndTypeForArtist(Shop shop,Integer type);

	/** 
	 * @Method getArtworkListByShopForArtist
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public List<Artwork> getArtworkListByShopForArtist(Shop shop);

	/** 
	 * @Method saveOrUpdateArtworkForArtist
	 * @exception TODO
	 * @param artwork
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public boolean saveOrUpdateArtworkForArtist(Artwork artwork);

	/** 
	 * @Method getArtworkByIdForArtist
	 * @exception TODO
	 * @param artwork_id
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	public Artwork getArtworkByIdForArtist(Long artwork_id);

}
