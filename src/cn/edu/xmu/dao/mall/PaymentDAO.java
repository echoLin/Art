/**
 * @Title {filename}
 * @Package cn.edu.xmu.dao.mall
 * @exception TODO
 * @author echo
 * @date 2015年12月30日 上午93723
 * @version V1.0
 */
package cn.edu.xmu.dao.mall;

import java.util.List;

import cn.edu.xmu.entity.Order;
import cn.edu.xmu.entity.Payment;
import cn.edu.xmu.entity.User;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file PaymentDAO.java
 * @package cn.edu.xmu.dao.mall
 * @project Art
 * @exception TODO
 */
public interface PaymentDAO {
	
	public Payment saveOrUpdatePayment(Payment payment) throws Exception;
	
	public Payment getPaymentByIdAndFrom(Long id, User user);
	
	public Payment getPaymentByIdAndTo(Long id,User user);
	
	public List<Payment> getPaymentListByOrderAndFrom(Order order,User user);
	
	public List<Payment> getPaymentListByOrderAndTo(Order order,User user);
	
}
