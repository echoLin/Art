package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Shop;

/**
 * 
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file ShopDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface ShopDAO {
	/**
	 * 
	 * @Method getShopList
	 * @exception TODO
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Shop> getShopListForArtist(String page);
	
	/**
	 * 
	 * @Method getShopListByCategory
	 * @exception TODO
	 * @param category_id
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public List<Shop> getShopListByCategoryForArtist(String category_id, String page);
	
	/**
	 * 
	 * @Method getShopById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月19日
	 */
	public Shop getShopByIdForArtist(Long id);
	
	/**
	 * 
	 * @Method getShopListByArtist
	 * @exception TODO
	 * @param artist_id
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public List<Shop> getShopListByArtistForArtist(Artist artist, Integer page);

	/** 
	 * @Method saveOrUpdateShop
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月24日
	 */
	public boolean saveOrUpdateShop(Shop shop);
	
	/** 
	 * @Method getShopByName
	 * @exception TODO
	 * @param name
	 * @return
	 * @author Qing
	 * @time 2015年12月24日
	 */
	public Shop getShopByNameForArtist(String name);
	
	/**
	 * 
	 * @Method getShopByArtistAndShop_id
	 * @exception TODO
	 * @param artist
	 * @param shop_id
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public Shop getShopByArtistAndShop_idForArtist(Artist artist, Long shop_id);
	
	/**
	 * 
	 * @Method getShopListByArtistAndIsPassed
	 * @exception TODO
	 * @param artist
	 * @param is_passed
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Shop> getShopListByArtistAndIsPassed(Artist artist, Integer is_passed, Integer page);
	
	
	
	//ForUser
	public List<Shop> getShopListByArtistForUser(Artist artist, Integer page);
	
	public Shop getShopByIdForUser(Long id);
	
	public List<Shop> getShopListByIdListForUser(List<Long> idList);
	
	public List<Shop> getShopListByCategoryAndIsCusForUser(Long category_id, Integer isCus, Integer page);
	

	/** 
	 * @Method getShopById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public Shop getShopById(Long id);

	/** 
	 * @Method getShopListByArtist
	 * @exception TODO
	 * @param artist
	 * @param page
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public List<Shop> getShopListByArtist(Artist artist, Integer page);

}
