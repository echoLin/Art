/**
 * 
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.JSON;
import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Shop;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 Weltion
 * All rights reserved
 *
 * @file OrderDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class OrderDAOImpl implements OrderDAO{
	
	private SessionFactory sessionFactory;
	Integer pageSize = 5;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Order getOrderByIdAndUser(Long id,Long user_id) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderByIdAndUser");
		User u = new User();
		u.setUserid(user_id);
		query.setParameter("user", u);
		query.setParameter("id", id);
		return (Order) query.uniqueResult();
	}
	
	public Order getOrderByIdAndShop(Long id,Shop shop){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderByIdAndShop");
		query.setParameter("shop", shop);
		query.setParameter("id", id);
		return (Order) query.uniqueResult();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderListByUserAndStatus(Long user_id,Integer status,Integer page){
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByUserAndStatus");
		User u = new User();
		u.setUserid(user_id);
		query.setParameter("user",u);
		query.setParameter("status", status);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderListByUserAndType(Long user_id, Integer type, Integer page) {
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByUserAndType");
		User u = new User();
		u.setUserid(user_id);
		query.setParameter("user",u);
		query.setParameter("type", type);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderListByShopAndType(Shop shop, Integer type, Integer page) {
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByShopAndType");
		query.setParameter("shop",shop);
		query.setParameter("type", type);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderListByShopAndStatus(Shop shop, Integer status, Integer page) {
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByShopAndStatus");
		query.setParameter("shop",shop);
		query.setParameter("status", status);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}
	

	@Override
	public Order saveOrUpdateOrder(Order order) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return order;
	}
	
	
	public List<Order> getOrderListByTypeAndShopAndStatus(Integer type,Shop shop, Integer status, Integer page){
					 //getOrderListByShopAndTypeAndStatus
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByShopAndTypeAndStatus");
		query.setParameter("shop",shop);
		query.setParameter("type", type);
		query.setParameter("status", status);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}
	
	public List<Order> getOrderListByTypeAndUserAndStatus(Integer type,User user, Integer status, Integer page){
		
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Order.getOrderListByTypeAndUserAndStatus");
		query.setParameter("user",user);
		query.setParameter("type", type);
		query.setParameter("status", status);
		query.setFirstResult((page-1)*pageSize);
		query.setMaxResults(pageSize);
		return query.list();
		
	}


}
