/**
 * 
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Weltion
 * All rights reserved
 *
 * @file OrderDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface OrderDAO {

	public Order getOrderByIdAndUser(Long id,Long user_id);
	
	public Order getOrderByIdAndShop(Long id,Shop shop);
	
	public List<Order> getOrderListByUserAndStatus(Long user_id,Integer status,Integer page);
	
	public List<Order> getOrderListByUserAndType(Long user_id,Integer type,Integer page);
	
	public Order saveOrUpdateOrder(Order order) throws Exception;
	
	public List<Order> getOrderListByShopAndType(Shop shop, Integer type, Integer page);
	
	public List<Order> getOrderListByShopAndStatus(Shop shop, Integer status, Integer page);
	
	public List<Order> getOrderListByTypeAndShopAndStatus(Integer type,Shop shop, Integer status, Integer page);
	
	public List<Order> getOrderListByTypeAndUserAndStatus(Integer type,User user, Integer status, Integer page);
	
}
