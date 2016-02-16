/**
 * 
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Weltion
 * All rights reserved
 *
 * @file OrderService.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 订单接口
 */
public interface OrderService {

	/**
	 * 
	 * @Method getOrderByIdAndUser
	 * @exception TODO
	 * @param id
	 * @param user_id
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Order getOrderByIdAndUser(Long id,Long user_id);
	
	/**
	 * 
	 * @Method getOrderByIdAndShop
	 * @exception TODO
	 * @param id
	 * @param shop
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Order getOrderByIdAndShop(Long id,Shop shop);
	
	/**
	 * 
	 * @Method getOrderListByUserAndStatus
	 * @exception TODO
	 * @param user_id
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByUserAndStatus(Long user_id,Integer status,Integer page);
	
	/**
	 * 
	 * @Method getOrderListByUserAndType
	 * @exception TODO
	 * @param user_id
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByUserAndType(Long user_id,Integer type,Integer page);
	
	/**
	 * 
	 * @Method getOrderListByShopAndStatus
	 * @exception TODO
	 * @param shop
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByShopAndStatus(Shop shop,Integer status,Integer page);
	
	/**
	 * 
	 * @Method getOrderListByShopAndType
	 * @exception TODO
	 * @param shop
	 * @param type
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByShopAndType(Shop shop,Integer type,Integer page);
	
	/**
	 * 
	 * @Method saveOrUpdateOrder
	 * @exception TODO
	 * @param order
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public JSON saveOrUpdateOrder(Order order);
	
	/**
	 * 
	 * @Method getOrderListByTypeAndShopAndStatus
	 * @exception TODO
	 * @param type
	 * @param shop
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByTypeAndShopAndStatus(Integer type,Shop shop, Integer status, Integer page);
	
	/**
	 * 
	 * @Method getOrderListByTypeAndUserAndStatus
	 * @exception TODO
	 * @param type
	 * @param user
	 * @param status
	 * @param page
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Order> getOrderListByTypeAndUserAndStatus(Integer type,User user, Integer status, Integer page);
	
	/**
	 * 
	 * @Method saveOrUpdatePayment
	 * @exception TODO
	 * @param payment
	 * @return
	 * @throws Exception
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Payment saveOrUpdatePayment(Payment payment) throws Exception;
	
	/**
	 * 
	 * @Method getPaymentByIdAndFrom
	 * @exception TODO
	 * @param id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Payment getPaymentByIdAndFrom(Long id, User user);
	
	/**
	 * 
	 * @Method getPaymentByIdAndTo
	 * @exception TODO
	 * @param id
	 * @param user
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public Payment getPaymentByIdAndTo(Long id,User user);
	
	/**
	 * 
	 * @Method getPaymentListByOrderAndFrom
	 * @exception TODO
	 * @param order
	 * @param user
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Payment> getPaymentListByOrderAndFrom(Order order,User user);
	
	/**
	 * 
	 * @Method getPaymentListByOrderAndTo
	 * @exception TODO
	 * @param order
	 * @param user
	 * @return
	 * @author echo
	 * @time 2016年1月17日
	 */
	public List<Payment> getPaymentListByOrderAndTo(Order order,User user);
	
}
