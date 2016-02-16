/**
 * 
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Category;
import cn.edu.xmu.entity.Favorite;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ShopService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 店铺管理接口
 */
public interface ShopService {

	/** 
	 * @Method saveOrUpdateShop
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @param category_id 
	 * @param user 
	 * @time 2015年12月24日
	 */
	public JSON saveOrUpdateShop(Shop shop, Long category_id, User user);

	/** 
	 * @Method getCategoryList
	 * @exception TODO
	 * @return
	 * @author Qing
	 * @time 2015年12月24日
	 */
	public List<Category> getCategoryList();
	
	/**
	 * 
	 * @Method saveOrUpdateArtwork
	 * @exception 保存作品
	 * @param artwork
	 * @param shop_id
	 * @param category_id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月27日
	 */
	public JSON saveOrUpdateArtwork(Artwork artwork, Long shop_id, Long category_id, User user);
	
	/**
	 * 
	 * @Method addArtworkImg
	 * @exception 添加作品图片
	 * @param file
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public JSON addArtworkImg(MultipartFile file, User user);
	
	/**
	 * 
	 * @Method getArtworkById
	 * @exception 根据作品ID获取作品
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public Artwork getArtworkByIdForArtist(Long id);
	
	/**
	 * 
	 * @Method getShopByArtistAndShop_id
	 * @exception 根据艺术家和店铺id获取店铺
	 * @param artist
	 * @param shop_id
	 * @return
	 * @author echo
	 * @time 2015年12月26日
	 */
	public Shop getShopByArtistAndShop_idForArtist(Artist artist, Long shop_id);
	
	/** 
	 * @Method getShopListByArtist
	 * @exception TODO
	 * @param artist
	 * @return
	 * @author Qing
	 * @time 2015年12月27日
	 */
	public List<Shop> getShopListByArtistForArtist(Artist artist, Integer page);

	/** 
	 * @Method saveOrUpdateShop
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月28日
	 */
	public boolean saveOrUpdateShop(Shop shop);

	/** 
	 * @Method getCategoryById
	 * @exception TODO
	 * @param new_categoryId
	 * @return
	 * @author Qing
	 * @time 2015年12月28日
	 */
	public Category getCategoryById(Long id);

	/** 
	 * @Method saveAvatar
	 * @exception TODO
	 * @param file
	 * @param user
	 * @param shop_id
	 * @return
	 * @author Qing
	 * @time 2015年12月28日
	 */
	public JSON saveAvatar(MultipartFile file, User user, Long shop_id);


	
	
}
