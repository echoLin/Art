/**
 * @Title {filename}
 * @Package cn.edu.xmu.service.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月30日 下午84220
 * @version V1.0
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import cn.edu.xmu.entity.Address;
import cn.edu.xmu.entity.Artwork;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Lot;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file BuyService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 交易接口
 */
public interface BuyService {
	
	/**
	 * 
	 * @Method getArtworkById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public Artwork getArtworkById(Long id);
	
	/**
	 * 
	 * @Method getPaymentById
	 * @exception TODO
	 * @param id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public Payment getPaymentById(Long id, User user);
	
	/**
	 * 
	 * @Method getShopById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public Shop getShopById(Long id);
	
	/**
	 * 
	 * @Method getLotById
	 * @exception TODO
	 * @param id
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public Lot getLotById(Long id);
	
	/**
	 * 
	 * @Method getAddressListByUser
	 * @exception TODO
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public List<Address> getAddressListByUser(User user);
	
	/**
	 * 
	 * @Method createOrder
	 * @exception TODO
	 * @param artwork_id
	 * @param address_id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public JSON createOrder(Long artwork_id, Long address_id,User user);
	
	/**
	 * 
	 * @Method createDeposit
	 * @exception TODO
	 * @param lot_id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public JSON createDeposit(Long lot_id, User user);
	
	/**
	 * 
	 * @Method createBid
	 * @exception TODO
	 * @param lot_id
	 * @param money
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public JSON createBid(Long lot_id, Double money, User user);
	
	/**
	 * 
	 * @Method setPay
	 * @exception TODO
	 * @param payment_id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public JSON setPay(Long payment_id, User user);
	
	/**
	 * 
	 * @Method saveCustomOrder
	 * @exception TODO
	 * @param artwork
	 * @param category_id
	 * @param shop_id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2015年12月31日
	 */
	public JSON saveCustomOrder(Artwork artwork, Long category_id, Long shop_id, User user);

}
