/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月30日 上午93737
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file PaymentDAOImpl.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public class PaymentDAOImpl implements PaymentDAO{
	SessionFactory sessionFactory;
	Integer pageSize = 5;
	
	/**
	 * 
	 * @Method setSessionFactory
	 * @exception TODO
	 * @param sessionFactory
	 * @author echo
	 * @time 2015年12月24日
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午91108
	 */
	@Override
	public Payment saveOrUpdatePayment(Payment payment) throws Exception{
		sessionFactory.getCurrentSession().saveOrUpdate(payment);	
		return payment;
	}

	/**
	 * @Override
	 * @author echo
	 * @time 2015年12月30日 下午92924
	 */
	@Override
	public Payment getPaymentByIdAndFrom(Long id, User user) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Payment.getPaymentByIdAndFrom");
		query.setParameter("id", id);
		query.setParameter("from", user);
		return (Payment) query.uniqueResult();
	}

	/**
	*
	* @Override
	* @author Weltion
	* @time 2015年12月31日 上午25709
	 */
	@Override
	public Payment getPaymentByIdAndTo(Long id, User user) {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Payment.getPaymentByIdAndTo");
		query.setParameter("id", id);
		query.setParameter("to", user);
		return (Payment) query.uniqueResult();
	}

	
	public List<Payment> getPaymentListByOrderAndFrom(Order order,User user){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Payment.getPaymentListByOrderAndFrom");
		query.setParameter("order", order);
		query.setParameter("from", user);
		return query.list();
	}
	
	public List<Payment> getPaymentListByOrderAndTo(Order order,User user){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("Payment.getPaymentListByOrderAndTo");
		query.setParameter("order", order);
		query.setParameter("to", user);
		return query.list();
	}



}
