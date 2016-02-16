/**
 * @Title {filename}
 * @Package cn.edu.xmu.entity
 * @Description TODO
 * @author echo
 * @date 2015年12月31日 上午12:24:42
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
import javax.persistence.UniqueConstraint;

/**
 * @Copyright Copyright (c) 2015 echo
 * All rights reserved
 *
 * @file: deposit.java
 * @package: cn.edu.xmu.entity
 * @project: Art
 * @description: TODO
 */
@Entity
@Table(name="Deposit", uniqueConstraints={@UniqueConstraint(columnNames={"user_id","lot_id"})})
@NamedQueries({
	@NamedQuery(name="Deposit.getDepositByUserAndLot", query="from Deposit d where d.user=:user and d.lot=:lot"),
	@NamedQuery(name="Deposit.getDepositListByLot", query="from Deposit d where d.lot = :lot")
})
public class Deposit {
	@Id 
	@GeneratedValue
	private Long id;
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	private User user;
	@ManyToOne
	@JoinColumn(name="lot_id", updatable=false)
	private Lot lot;
	@Column(precision=10,scale=2)
	private Double price;
	private Date time;
	private Integer is_return;
	public Deposit() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Lot getLot() {
		return lot;
	}
	public void setLot(Lot lot) {
		this.lot = lot;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getIs_return() {
		return is_return;
	}
	public void setIs_return(Integer is_return) {
		this.is_return = is_return;
	}
}
