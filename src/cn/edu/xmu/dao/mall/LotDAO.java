/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月24日 下午95556
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Shop;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file LotDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface LotDAO {
	/**
	 * 
	 * @Method getLotListForUser
	 * @exception TODO
	 * @param category_id
	 * @param time
	 * @param page
	 * @return
	 * @author echo
	 * @time 2015年12月29日
	 */
	public List<Lot> getLotListForUser(Long category_id, Integer time, Integer page);
	
	/**
	 * 
	 * @param shop_id
	 * @param page
	 * @return
	 */
	public List<Object> getLotListByShopForUser(Long shop_id, Integer page);

	/** 
	 * @Method getLotListByShopForArtist
	 * @exception TODO
	 * @param shop
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public List<Lot> getLotListByShopForArtist(Shop shop);

	/** 
	 * @Method getLotListByShopAndIsPassedForArtist
	 * @exception TODO
	 * @param shop
	 * @param is_passed
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public List<Lot> getLotListByShopAndIsPassedForArtist(Shop shop, Integer is_passed);

	/** 
	 * @Method saveOrUpdateLot
	 * @exception TODO
	 * @param lot
	 * @return
	 * @author Qing
	 * @time 2015年12月29日
	 */
	public boolean saveOrUpdateLot(Lot lot) throws Exception;

	/** 
	 * @Method getLotByIdForArtist
	 * @exception TODO
	 * @param lot_id
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	public Lot getLotByIdForArtist(Long lot_id);

	/** 
	 * @Method deleteLot
	 * @exception TODO
	 * @param lot
	 * @return
	 * @author Qing
	 * @time 2015年12月30日
	 */
	public boolean deleteLot(Lot lot);
	
	/**
	 * 
	 * @Method getLotByIdForUser
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月30日
	 */
	public Lot getLotByIdForUser(Long id);
}
