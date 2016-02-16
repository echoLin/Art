/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月28日 下午10:34:58
 * @version V1.0
 */
package cn.edu.xmu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: Payment.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name="Payment")
@NamedQueries({
	
	@NamedQuery(name="Payment.getPaymentByIdAndFrom", 
			query="from Payment op where op.id=:id and op.from=:from"),
	@NamedQuery(name="Payment.getPaymentByIdAndTo", 
			query="from Payment op where op.id=:id and op.to=:to"),	
	@NamedQuery(name="Payment.getPaymentListByOrderAndTo", 
			query="from Payment op where op.order=:order and op.to=:to order by op.time desc"),	
	@NamedQuery(name="Payment.getPaymentListByOrderAndFrom", 
			query="from Payment op where op.order=:order and op.from=:from order by op.time desc")

})
public class Payment {
	@Id 
	@GeneratedValue
	protected Long id;
	@ManyToOne
	@JoinColumn(name="from_id", updatable=false)
	protected User from;
	@ManyToOne
	@JoinColumn(name="to_id", updatable=false)
	protected User to;
	@ManyToOne
	@JoinColumn(name="order_id", updatable=false)
	private Order order;
	@Column(precision=10,scale=2)
	protected Double price;
	protected String remark;
	protected Integer is_pay;//-1未付款 1已付款
	protected Date time;//支付时间
	
	public Payment() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getIs_pay() {
		return is_pay;
	}
	public void setIs_pay(Integer is_pay) {
		this.is_pay = is_pay;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
