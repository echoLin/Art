/**
 * 
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import cn.edu.xmu.entity.Artist;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Qing
 * All rights reserved
 *
 * @file ArtworkService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version TODO
 */
public interface ArtworkService {

	
	/** 
	 * @Method getArtworkListByShopAndType
	 * @exception TODO
	 * @param shop
	 * @param type
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	List<Artwork> getArtworkListByShopAndTypeForArtist(Shop shop, Integer type);

	/** 
	 * @Method getArtworkListByShop
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	List<Artwork> getArtworkListByShopForArtist(Shop shop);

	/** 
	 * @Method getLotListByShop
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	List<Lot> getLotListByShopForArtist(Shop shop);

	/** 
	 * @Method getLotListByShopAndIsPassedForArtist
	 * @exception TODO
	 * @param shop
	 * @param is_passed
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	List<Lot> getLotListByShopAndIsPassedForArtist(Shop shop, Integer is_passed);

	/** 
	 * @Method saveOrUpdateArtwork
	 * @exception TODO
	 * @param user
	 * @param artwork_id
	 * @return
	 * @author Qing
	 * @param type 
	 * @time 2015年12月29日
	 */
	JSON saveOrUpdateArtwork(User user, Long artwork_id, int type);

	/** 
	 * @Method saveOrUpdateLot
	 * @exception TODO
	 * @param user
	 * @param lot
	 * @param artwork_id
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	JSON toLot(User user, Lot lot, Long artwork_id);

	/** 
	 * @Method getLotByIDForArtist
	 * @exception TODO
	 * @param lot_id
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	Lot getLotByIDForArtist(Long lot_id);

	/** 
	 * @Method deleteLot
	 * @exception TODO
	 * @param lot
	 * @author Qing
	 * @time 2015年12月30日
	 */
	boolean deleteLot(Lot lot);

	/** 
	 * @Method getArtworkByIdForArtist
	 * @exception TODO
	 * @param artwork_id
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	Artwork getArtworkByIdForArtist(Long artwork_id);

	/** 
	 * @Method saveOrUpdateLot
	 * @exception TODO
	 * @param user
	 * @param newLot
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	JSON saveOrUpdateLot(User user, Lot lot);


	

}
