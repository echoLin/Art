package cn.edu.xmu.service.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ArtmallService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 商城Service
 */
public interface ArtmallService {

	/**
	 * 
	 * @Method getCategoryList
	 * @exception TODO
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Category> getCategoryList();
	
	/**
	 * 
	 * @Method getArtistList
	 * @exception TODO
	 * @param page
	 * @param isHot
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Artist> getArtistList(Integer page, boolean isHot);
	
	/**
	 * 
	 * @Method getArtworkListByCategoryAndType
	 * @exception TODO
	 * @param category_id
	 * @param type
	 * @param page
	 * @param isHot
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Artwork> getArtworkListByCategoryAndType(Long category_id, Integer type, Integer page, Boolean isHot);
	
	/**
	 * 
	 * @Method getShopListByCategoryAndIsCus
	 * @exception TODO
	 * @param category_id
	 * @param isCus
	 * @param page
	 * @param isHot
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Shop> getShopListByCategoryAndIsCus(Long category_id, Integer isCus, Integer page, Boolean isHot);
	
	/**
	 * 
	 * @Method getLotListByCategoryAndTime
	 * @exception TODO
	 * @param category_id
	 * @param time
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Lot> getLotListByCategoryAndTime(Long category_id, Integer time, Integer page);
	
	/**
	 * 
	 * @Method getArtworkById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Artwork getArtworkById(Long id);
	
	/**
	 * 
	 * @Method getArtistById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Artist getArtistById(Long id);
	
	/**
	 * 
	 * @Method getShopById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Shop getShopById(Long id);
	
	/**
	 * 
	 * @Method getShopListByArtist
	 * @exception TODO
	 * @param artist
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Shop> getShopListByArtist(Artist artist, Integer page);
	
	/**
	 * 
	 * @Method getArtworkListByArtist
	 * @exception TODO
	 * @param artist
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Artwork> getArtworkListByArtist(Artist artist, Integer page);
	
	/**
	 * 
	 * @Method getArtworkListByShop
	 * @exception TODO
	 * @param id
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Object> getArtworkListByShop(Long id, Integer type, Integer page);
	
	/**
	 * 
	 * @Method getLotById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Lot getLotById(Long id);
	
}
