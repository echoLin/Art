/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月30日 上午9:32:17
 * @version V1.0
 */
package cn.edu.xmu.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: OrderPayment.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@DiscriminatorValue("OrderPayment")

public class OrderPayment extends Payment{
	@ManyToOne
	@JoinColumn(name="order_id", updatable=false)
	private Order order;
	
	public OrderPayment() {
		super();
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
}
