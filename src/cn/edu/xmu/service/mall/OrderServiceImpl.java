/**
 * 
 */
package cn.edu.xmu.service.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xmu.entity.INFO;
import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;
import cn.edu.xmu.dao.mall.OrderDAO;
import cn.edu.xmu.dao.mall.PaymentDAO;

/**
 * @Copyright Copyright (c) 2015 Weltion
 * All rights reserved
 *
 * @file OrderServiceImpl.java
 * @package cn.edu.xmu.service.mall
 * @project Art
 * @version 实现订单接口
 */
public class OrderServiceImpl implements OrderService {

	@Autowired	
	private OrderDAO orderDAO;
	@Autowired
	private PaymentDAO paymentDAO;
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40629
	 */
	@Override
	public Order getOrderByIdAndUser(Long id,Long user_id){
		return orderDAO.getOrderByIdAndUser(id, user_id);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40632
	 */
	@Override
	public Order getOrderByIdAndShop(Long id,Shop shop){
		return orderDAO.getOrderByIdAndShop(id, shop);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40635
	 */
	@Override
	public List<Order> getOrderListByUserAndStatus(Long user_id,Integer status,Integer page){
		return orderDAO.getOrderListByUserAndStatus(user_id, status, page);
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40638
	 */
	@Override
	public List<Order> getOrderListByUserAndType(Long user_id,Integer type,Integer page){
		
		return orderDAO.getOrderListByUserAndType(user_id, type,page);
		
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40642
	 */
	@Override
	public List<Order> getOrderListByShopAndStatus(Shop shop,Integer status,Integer page){
		
		return orderDAO.getOrderListByShopAndStatus(shop, status, page);
		
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40645
	 */
	@Override
	public List<Order> getOrderListByShopAndType(Shop shop,Integer type,Integer page){
		
		return orderDAO.getOrderListByShopAndType(shop, type, page);
		
	}
	
	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40648
	 */
	@Override
	public JSON saveOrUpdateOrder(Order order) {
		
		if(order == null){
			return new JSON(INFO.Error, INFO.LoginMALL);
		}
		try {
			if(orderDAO.saveOrUpdateOrder(order)==null){
				return new JSON(INFO.Error, INFO.ActionError);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new JSON(INFO.Error, INFO.ActionError);
		}
		return new JSON(INFO.Success, "huhhooh");
		
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40653
	 */
	@Override
	public List<Order> getOrderListByTypeAndShopAndStatus(Integer type,
			Shop shop, Integer status, Integer page) {
	
		return orderDAO.getOrderListByTypeAndShopAndStatus(type, shop, status, page);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40655
	 */
	@Override
	public List<Order> getOrderListByTypeAndUserAndStatus(Integer type,
			User user, Integer status, Integer page) {
		
		return orderDAO.getOrderListByTypeAndUserAndStatus(type, user, status, page);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40658
	 */
	@Override
	public Payment saveOrUpdatePayment(Payment payment) throws Exception {
		
		return paymentDAO.saveOrUpdatePayment(payment);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40701
	 */
	@Override
	public Payment getPaymentByIdAndFrom(Long id, User user) {
		
		return paymentDAO.getPaymentByIdAndFrom(id, user);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40704
	 */
	@Override
	public Payment getPaymentByIdAndTo(Long id, User user) {
		
		return paymentDAO.getPaymentByIdAndTo(id, user);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40707
	 */
	@Override
	public List<Payment> getPaymentListByOrderAndFrom(Order order, User user) {
		// TODO Auto-generated method stub
		return paymentDAO.getPaymentListByOrderAndFrom(order, user);
	}

	/**
	 * 
	 * @Override
	 * @author echo
	 * @time 2016年1月17日 下午40710
	 */
	@Override
	public List<Payment> getPaymentListByOrderAndTo(Order order, User user) {
		// TODO Auto-generated method stub
		return paymentDAO.getPaymentListByOrderAndTo(order, user);
	}
	
	
	

	
}
